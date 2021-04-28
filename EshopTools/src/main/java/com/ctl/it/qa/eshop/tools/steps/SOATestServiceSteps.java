package com.ctl.it.qa.eshop.tools.steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Base64;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

//import cucumber.deps.com.thoughtworks.xstream.core.util.Base64Encoder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.security.KeyStore;

import com.ctl.it.qa.staf.Steps;

import net.thucydides.core.annotations.Step;

@SuppressWarnings("serial")
public class SOATestServiceSteps extends Steps {

	private final org.slf4j.Logger slf4jLogger = LoggerFactory.getLogger(SOATestServiceSteps.class);

	@Step
	public void GetRequestandURL(String url) throws ClientProtocolException, IOException, KeyManagementException, NoSuchAlgorithmException, TransformerException, ParserConfigurationException, SAXException {
		exeSOAPRequestbyBasicAuth("CDS_Request", url);
		slf4jLogger.info("Connection Established");
	}

	@Step
	public void runSOAPUI() {
		// String s = getxmlvaluesbyTag("CDS_Response", "TNCollection");
		slf4jLogger.info("Run succesfull");
	}

	@Step
	public void getreponse() {

		slf4jLogger.info("Response returned");
	}

	@Step
	public void exeSOAPRequest(String requestfile, String URL) throws ClientProtocolException, IOException {

		String path = System.getProperty("user.dir") + "/EshopTools/TestData/" + requestfile + ".xml";
		path = path.replaceAll("EShopTests/", "");
		File soaprequest = new File(path);

		System.out.println(soaprequest);
		// Provide Request File
		HttpPost request = new HttpPost(URL);

		request.addHeader("Content-Type", "text/xml");

		// String encoding = Base64Encoder.encode("BMPAPP" + ":" +
		// "FM59wYtos4WceVHT2nLaxRQh");
		// request.setHeader(HttpHeaders.AUTHORIZATION, "Basic " + encoding);
		request.setEntity(new InputStreamEntity(new FileInputStream(soaprequest)));

		// Run Request in SOAP UI
		CloseableHttpClient client = HttpClients.createDefault();
		CloseableHttpResponse response = client.execute(request);

		HttpEntity entity = response.getEntity();
		String content = EntityUtils.toString(entity);
		System.out.println(content);

		// Save the response
		requestfile = requestfile.replaceAll("_Request", "_Response");
		System.out.println(requestfile);
		int status = response.getStatusLine().getStatusCode();
		System.out.println(status);
		if (response.getStatusLine().getStatusCode() == 200) {

			String path2 = System.getProperty("user.dir") + "/EshopTools/TestData/" + requestfile + ".xml";
			path = path2.replaceAll("EShopTests/", "");
			FileWriter fw = new FileWriter(path);
			fw.write(content);
			fw.close();
		} else {
			System.out.println("Response has issues and received as " + content);
		}

	}

	public static void exeSOAPRequestbyBasicAuth(String requestfile, String URL)
			throws ClientProtocolException, IOException, NoSuchAlgorithmException, KeyManagementException,
			TransformerException, ParserConfigurationException, SAXException {
		
		String path = System.getProperty("user.dir") + "/EshopTools/TestData/" + requestfile + ".xml";
		path = path.replaceAll("EShopTests/", "");
		File soaprequest = new File(path);

		DefaultHttpClient httpclient = new DefaultHttpClient();

		// Provide Request File
		HttpPost request = new HttpPost(URL);
		request.addHeader("Content-Type", "text/xml");
		request.setEntity(new InputStreamEntity(new FileInputStream(soaprequest)));

		// Set Basic Authentication
		String encoding = Base64.getEncoder().encodeToString(("BMPAPP:FM59wYtos4WceVHT2nLaxRQh").getBytes()); // Provide
																												// Username
																												// and
																												// Password
		request.setHeader(HttpHeaders.AUTHORIZATION, "Basic " + encoding);

		// Certification
		// ******************************************Certification*********************************************
		SSLContext sslContext = SSLContext.getInstance("SSL");

		// set up a TrustManager that trusts everything
		sslContext.init(null, new TrustManager[] { new X509TrustManager() {
			public X509Certificate[] getAcceptedIssuers() {
				//System.out.println("getAcceptedIssuers =============");
				return null;
			}

			public void checkClientTrusted(X509Certificate[] certs, String authType) {
				//System.out.println("checkClientTrusted =============");
			}

			public void checkServerTrusted(X509Certificate[] certs, String authType) {
				//System.out.println("checkServerTrusted =============");
			}
		} }, new SecureRandom());

		SSLSocketFactory sf = new SSLSocketFactory(sslContext);
		Scheme httpsScheme = new Scheme("https", 443, sf);
		SchemeRegistry schemeRegistry = new SchemeRegistry();
		schemeRegistry.register(httpsScheme);
		ClientConnectionManager cm = new SingleClientConnManager(schemeRegistry);

		httpclient = new DefaultHttpClient(cm);

		// *****************************************************************************************************

		// Run Request in SOAP UI
		CloseableHttpResponse response = httpclient.execute(request);

		HttpEntity entity = response.getEntity();
		String content = EntityUtils.toString(entity);
		content = prettyPrintxml(content);
		System.out.println(content);

		// Save the response
		requestfile = requestfile.replaceAll("_Request", "_Response");
		// System.out.println(requestfile);
		int status = response.getStatusLine().getStatusCode();
		// System.out.println(status);
		if (response.getStatusLine().getStatusCode() == 200) {
			
			path = System.getProperty("user.dir") + "/EshopTools/TestData/" + requestfile + ".xml";
			path = path.replaceAll("EShopTests/", "");
			
			FileWriter fw = new FileWriter(path);
			fw.write(content);
			fw.close();
		} else {
			System.out.println("************Response has issues and received as ************** \n" + content);
		}

	}

	public static String prettyPrintxml(String xmlString)
			throws TransformerException, ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		Document document = docBuilder.parse(new InputSource(new StringReader(xmlString)));

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		DOMSource source = new DOMSource(document);
		StringWriter strWriter = new StringWriter();
		StreamResult result = new StreamResult(strWriter);

		transformer.transform(source, result);

		return strWriter.getBuffer().toString();

	}

	public static void modifyxmlvaluesbyTag(String fileName, String tagName, String value)
			throws ParserConfigurationException, SAXException, IOException, TransformerException {
		// Take values from Response
		String path = System.getProperty("user.dir") + "/EshopTools/TestData/" + fileName + ".xml";
		path = path.replaceAll("EShopTests/", "");
		File response = new File(path);
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(response);

		// Get the tag from xml and set value
		Node search = doc.getElementsByTagName(tagName).item(0);
		search.setTextContent(value);

		// write it back to the xml
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(response);
		transformer.transform(source, result);

		// System.out.println("Done");
	}

	public static String getxmlvaluesbyTag(String responsefile, String tagName)
			throws ParserConfigurationException, SAXException, IOException {
		// Take values from Response
		String path = System.getProperty("user.dir") + "/EshopTools/TestData/" + responsefile + ".xml";
		path = path.replaceAll("EShopTests/", "");
		FileWriter fw = new FileWriter(path);

		File response = new File(path);
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		Document doc = docBuilder.parse(response);
		doc.getDocumentElement().normalize();
		return doc.getElementsByTagName(tagName).item(0).getTextContent();

	}

}

package idv.springboot.demo.Controller.Business;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/business/doHttp")
public class HttpController extends WebController {

	@RequestMapping("/getRs")
	public void getRs() throws ClientProtocolException, IOException {

		String content = this.doPost();

		this.writeFile(content);

	}

	/**
	 * doPost 發rs
	 * 
	 * @return
	 * @throws IOException
	 */
	private String doPost() throws IOException {

		CloseableHttpResponse response = null;

		CloseableHttpClient httpClient = null;

		StringBuilder result = new StringBuilder();

		try {

			httpClient = HttpClients.createDefault();

			HttpGet request = new HttpGet("https://tw.yahoo.com/");

			// add request headers
			request.addHeader(HttpHeaders.USER_AGENT, "test");
			response = httpClient.execute(request);

			// Get HttpResponse Status
			System.out.println(response.getProtocolVersion()); // HTTP/1.1
			System.out.println(response.getStatusLine().getStatusCode()); // 200
			System.out.println(response.getStatusLine().getReasonPhrase()); // OK
			System.out.println(response.getStatusLine().toString()); // HTTP/1.1 200 OK

			HttpEntity entity = response.getEntity();

			if (entity != null) {

				InputStream in = response.getEntity().getContent();

				BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));

				String line;

				while ((line = reader.readLine()) != null) {

					result.append(line);

					result.append('\r');
				}

				reader.close();
			}

		} catch (Exception e) {

			logger.info("e >> " + e.getMessage());

		} finally {

			response.close();

			httpClient.close();
		}

		return result.toString();
	}

	/**
	 * writeFile 寫檔
	 * 
	 * @param val
	 * @throws IOException
	 */
	private void writeFile(String val) throws IOException {

		String path = "";

		FileWriter fw = new FileWriter(path);

		fw.write(val);

		fw.flush();

		fw.close();
	}
}

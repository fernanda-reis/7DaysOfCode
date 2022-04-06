package interfaces;

import java.io.IOException;

public interface APIClient {

	String getBody() throws IOException, InterruptedException;
	String type();
}

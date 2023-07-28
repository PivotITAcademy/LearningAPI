package productPackage;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetProductById {

	@Test
	public void testGetProductById(ITestContext context) {
		
		given().when().log().all().get("/products/{productId}",context.getAttribute("productId")).then().log().all().statusCode(200);
	}
}

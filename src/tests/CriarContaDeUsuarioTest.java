package tests;

import static org.junit.Assert.assertEquals;

import java.util.UUID;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CriarContaDeUsuarioTest {

	@Test
	public void testCriarContaDeUsuarioComSucesso() {
		
		//configurando o driver para executar o navegador do google chrome
		System.setProperty("webdriver.chrome.driver", "c:\\testes\\chromedriver.exe");
		
		//abrindo o google chrome
		WebDriver driver = new ChromeDriver();
		
		//acessando a página de cadastro de usuários
		driver.get("http://appcontascoti-001-site1.dtempurl.com/Account/Register");
		
		//colocando o navegador em 'tela cheia'
		driver.manage().window().maximize();
		
		//Preencher os campos do formulário;
		driver.findElement(By.xpath("//*[@id=\"Nome\"]")).sendKeys("Sergio Mendes");
		driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("sergio.coti" + UUID.randomUUID() + "@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"Senha\"]")).sendKeys("@Teste1234");
		driver.findElement(By.xpath("//*[@id=\"SenhaConfirmacao\"]")).sendKeys("@Teste1234");
		
		//clicar no botão de cadastro
		driver.findElement(By.xpath("/html/body/div/div/div/div/form/div[5]/input")).click();
		
		//ler a mensagem exibida pelo sistema
		String mensagem = driver.findElement(By.xpath("/html/body/div[1]")).getText();
		
		//comparando o conteúdo da mensagem
		assertEquals("Sucesso! Parabéns, sua conta foi cadastrada com sucesso.", mensagem);
		
		//fechando o navegador
		driver.close();
	}

}

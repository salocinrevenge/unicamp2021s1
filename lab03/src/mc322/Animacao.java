package mc322.lab03;

public class Animacao {
	AquarioLombriga aquario;
	String acoes;
	int posLeitura;
		
	Animacao(String acoes)
	{
		this.acoes = acoes;
		int tamanhoA = 0;
		tamanhoA += 10*Character.getNumericValue(this.acoes.charAt(0));
		tamanhoA += Character.getNumericValue(this.acoes.charAt(1));
		int tamanhoL = 0;
		tamanhoL += 10*Character.getNumericValue(this.acoes.charAt(2));
		tamanhoL += Character.getNumericValue(this.acoes.charAt(3));
		int pos = 0;
		pos += 10*Character.getNumericValue(this.acoes.charAt(4));
		pos += Character.getNumericValue(this.acoes.charAt(5));
		posLeitura = 6;
		aquario = new AquarioLombriga(tamanhoA, tamanhoL, pos);
		//System.out.printf("tamahoA: %d, tamanhoL: %d, pos: %d\n",tamanhoA,tamanhoL,pos);
		System.out.println(aquario.apresentar());
		rodar();
	}
	
	boolean passo()
	{
		
		if(posLeitura >= acoes.length())
			return false;
		
		//System.out.printf("acao escolhida: %c\n",acoes.charAt(posLeitura));
		switch(acoes.charAt(posLeitura))
		{
		case 'M':
		{
			aquario.mover();
			break;
		}
		case 'C':
		{
			aquario.crescer();
			break;
		}
		case 'V':
		{
			aquario.virar();
			break;
		}
		default:
		{
			System.out.println("O meu fi, fala minha lingua!");
			break;
		}
		
		
		}
		System.out.println(aquario.apresentar());
		posLeitura++;
		return true;
	}
	
	void rodar()
	{
		while(passo());
	}
	
	String apresenta()
	{
		return aquario.apresentar();
	}
	
	
}

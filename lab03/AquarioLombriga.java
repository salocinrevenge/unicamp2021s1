package mc322.lab03;

public class AquarioLombriga {
	int tamanhoLombriga;
	int x;
	int tamanhoAquario;
	//só é neccessário x, já que nosso cenário é unidimensional
	boolean direcaoLombriga;//true = direita, false = esquerda. Equivalente a "boolean direita;"
	
	AquarioLombriga(int tamanhoAquario, int tamanhoLombriga, int posicao)
	{
		this.tamanhoAquario=tamanhoAquario;
		this.tamanhoLombriga=tamanhoLombriga;
		x=posicao;
		if(!dentroIntervalo(x,1,tamanhoAquario)||!dentroIntervalo(x+tamanhoLombriga,1,tamanhoAquario))
		{
			System.out.println("Oh no, sua lombriga é tão grande que quebrou o aquário!!!");
			this.tamanhoAquario+=2*tamanhoLombriga;
		}
		direcaoLombriga = true;
	}
	
	void crescer()
	{
		if(x>1)
			tamanhoLombriga++;
		else
			System.out.println("Sua lombriga está tão grande que bate na parede! Não pode mais crescer!");
	}
	
	void mover()
	{
		if(direcaoLombriga)
		{
			if(x+tamanhoLombriga==tamanhoAquario+1)
			{
				System.out.println("Sua lombriga bateu a cabeça!\n Auch!!!\n Ela se virou\n");
				virar();
			}
			else
				x++;
		}
		else
		{
			if(x==1)
			{
				System.out.printf("Sua lombriga bateu a cabeça!\n Auch!!!\n Ela se virou\n");
				virar();
			}
			else
				x--;
		}
		
	}

	void virar()
	{
		direcaoLombriga = !direcaoLombriga;
	}
	
	boolean dentroIntervalo(int valor, int min, int max)
	{
		if(valor >=min)
			if(valor <=max)
				return true;
		return false;
	}
	
	String apresentar()
	{
		char cCenario[] = new char[tamanhoAquario];
		for(int i = 1 ; i <= tamanhoAquario ; i++)
		{
			if(dentroIntervalo(i,x, x + tamanhoLombriga-1))
			{
				if(direcaoLombriga)
				{
					if(i==x+tamanhoLombriga-1)
						cCenario[i-1]='O';
					else
						cCenario[i-1]='@';
				}
				else
				{
					if(i==x)
						cCenario[i-1]='O';
					else
						cCenario[i-1]='@';
				}
				
				
			}
			else
				cCenario[i-1]='#';
		}
		String cenario=String.copyValueOf(cCenario);
		return cenario;
	}
}

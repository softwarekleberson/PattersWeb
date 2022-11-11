import esiii2022.dominio.Cliente;


public class TesteMap {

	public static void main(String[] args) {
	/*	Map<String, List<String>> mapa = new HashMap<String, List<String>>();
		
		
		List<String> sp = new ArrayList<String>();
		sp.add("Mogi das Cruzes");
		sp.add("São José dos Campos");
		sp.add("Guarulhos");
		List<String> rj = new ArrayList<String>();
		rj.add("Barra Mansa");
		rj.add("Petropolis");
		List<String> mg = new ArrayList<String>();
		mg.add("Ouro Preto");
		mg.add("Belo Horizonte");
		
		mapa.put("SP", sp);
		mapa.put("RJ", rj);	
		mapa.put("MG", mg);
		
	
		Collection chaves= mapa.keySet();
		
		for(Object o:chaves){
			System.out.println(o+" : ");
			for(String cidade:mapa.get(o)){
				System.out.println(cidade);
			}
		}*/
		
		String s = "";
		long ini = System.currentTimeMillis();
		for(int i=0; i<100000;i++){
			String n = ""+i;
			s=s+n;
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println(end-ini);
		
		ini = System.currentTimeMillis();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<100000;i++){
			String n = ""+i;
			sb.append(n);
		}
		
		end = System.currentTimeMillis();
		
		System.out.println(end-ini);
		
		
		

	}

}

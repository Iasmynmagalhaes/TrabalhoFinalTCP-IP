package Adedonha;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Random;

/*
 * @autores Iasmyn Magalhaes e Denys Maciel
 */

public class Servidor {

	
	private boolean executando;
	private char letra;
	
	private static char gerarLetra() {
		char[] letras = {'Q','W','E','R','T','U','I','O','P','A','S','D',
				'F','G','H','J','L','Z','C','V','B','M','N'};

		Random ran = new Random();
		char letraAleatoria = letras[ran.nextInt(23)];

		return letraAleatoria;
	}
	private static String[] getLugares() {
		String[] palavras = {
				"Abatiá","Abeba","Acari","Aceguá","Acra","Açu","Adis","Adolfo","Afrânio","Agrestina","Agudos","Albertina","Alecrim",
				"Alegre","Aliança","Almas","Altair","Altamira","Altinho","Altos","Amã","Americana","Amontada","Amparo","Ampére","Anahy",
				"Ananás","Anastácio","Ancara","Angélica","Angical","Antas","Aracruz","Arame","Arara","Araras","Arco-Íris","Arcos","Areado",
				"Areal","Areia","Argel","Ariranha","Aroeiras","Assaí","Assunção","Astana","Atenas","Aurora","Avaí","Acre","Alagoas",
				"Amapá","Amazonas","Alabama","Alasca","Arizona","Altai","Afeganistão","Albânia","Alemanha","Angola","Argélia","Argentina",
				"Armênia","Austrália","Áustria","Azerbaijão",
				"Bacuri","Bagdá","Bagre","Baião","Baku","Baldim","Baliza","Bálsamo","Balsas","Bananal","Bananeiras","Bandeira","Bangcoc",
				"Bangui","Banjul","Barão","Baraúna","Barcelona","Barra","Barracão","Barreira","Barreiros","Barrinha","Barro","Barroso",
				"Basseterre","Batalha","Batatais","Bebedouro","Beirute","Belém","Betânia","Bezerros","Bicas","Biquinhas","Bodó","Bofete",
				"Bombinhas","Bonfim","Bonito","Bozano","Braga","Branquinha","Braúna","Brazzaville","Brejo","Brotas","Bugre","Buritis",
				"Buritizeiro","Bahia","Baixa Califórnia do Sul","Baixa Califórnia","Bahamas","Barbados","Belarus","Bélgica","Bermudas",
				"Bolívia","Brasil","Brunei","Bulgária","Butão",
				"Caatiba","Cabaceiras","Cabeceiras","Cabixi","Cabrobó","Cabul","Caçador","Cáceres","Cachoeira","Cacimbas","Caculé","Cafarnaum",
				"Caiana","Cairo","Cajazeiras","Cajueiro","Calçado","Caldas","Califórnia","Camberra","Cambira","Cametá","Campanha","Campestre",
				"Campinas","Canaã","Canas","Candelária","Canela","Cantá","Cantagalo","Canudos","Capela","Capim","Capitão","Capixaba","Caraá",
				"Caracas","Caracol","Caraí","Carazinho","Cardoso","Careiro","Caridade","Carmo","Carneiros","Carolina","Carrancas","Casca",
				"Cascavel","Casinhas","Castelo","Castries","Catarina","Cavalcante","Cedro","Chácara","Chalé","Chaves","Cidreira","Cipó","Cláudia",
				"Cláudio","Colombo","Comodoro","Conacri","Concórdia","Conde","Congo","Copenhagem","Coxim","Cristal","Cristina","Croatá","Cruz",
				"Cruzeta","Cuité","Cunha","Cupira","Curimatá","Currais","Curuá","Cutias","Campeche","Ceará","Chiapas","Chihuahua","Coahuila","Colima",
				"Califórnia","Colorado","Camarões","Camboja","Canadá","Cazaquistão","Chile","China","Cingapura","Colômbia","Congo","Cuba",
				"Dacca","Dakar","Dallas","Dalton","Damasco","Damião","Damolândia","Danilov","Danville","Darlington","Datas","Dayton","Dearborn",
				"Decatur","Delta","Deltona","Demopolis","Denise","Denton","Denver","Derrubadas","Descalvado","Descanso","Descoberto","Desterro",
				"Detroit","Diadema","Diamante","Dickinson","Digora","Dionísio","Divino","Divinópolis","Dno","Dobrada","Dodoma","Doha","Dormentes",
				"Douglas","Dourado","Dourados","Dover","Downey","Dracena","Duartina","Dublin","Dubna","Dubuque","Dueré","Duluth","Dumont",
				"Dundalk","Durango","Durham","Daguestão","Dakota do Norte","Dakota do Sul","Delaware","Distrito de Colúmbia","Distrito Federal",
				"Durango","Dinamarca","Djibuti","Dominica",
				"Ecoporanga","Edealina","Edéia","Edmond","Eldorado","Elektrostal","Elisiário","Elista","Elko","Elsmere","Emas","Embaúba","Encantado",
				"Encanto","Encruzilhada","Engels","Enid","Envira","Equador","Erechim","Ererê","Erevan","Erie","Ermo","Ernestina","Ervália","Escada",
				"Escondido","Esmeralda","Esmeraldas","Esperança","Espinosa","Esplanada","Espumoso","Esquel","Estação","Estância","Esteio","Estiva",
				"Estocolmo","Estreito","Estrela","Eufaula","Eugene","Eureka","Eusébio","Evanston","Everett","Extrema","Exu","Entre Ríos","Espírito Santo",
				"Egito","El Salvador","Equador","Eritréia","Eslováquia","Eslovênia","Espanha","Estados Unidos","Estônia","Etiópia",
				"Fachinal","Fagundes","Faina","Fairfax","Fallon","Fama","Fargo","Faro","Farol","Fartura","Fátima","Faxinal","Feijó","Feliz","Fênix",
				"Fernão","Ferreiros","Ferros","Fervedouro","Figueira","Filadélfia","Flexeiras","Floraí","Floreal","Florence","Flores","Floresta",
				"Florestal","Floriano","Flórida","Formiga","Formosa","Formoso","Forquilha","Fortaleza","Fortim","Fortuna","Franca","Frankfort",
				"Franklin","Frecheirinha","Frederick","Freeport","Freetown","Fremont","Fresno","Friazino","Frolovo","Fronteira","Frutal","Fullerton",
				"Fulton","Funafuti","Fundão","Fundão","Funilândia","Flórida","Formosa","Fiji","Filipinas","Finlândia","França",
				"Gaborone","Gagarin","Galesburg","Gália","Galileia","Galinhos","Galvão","Gameleira","Gameleiras","Gandu","Garça","Gardner","Garibaldi",
				"Garupá","Gary","Gaspar","Gastonia","Gavião","Geminiano","Gentil","Georgetown","Getulina","Gilbert","Glendale","Glicério","Glória",
				"Glorinha","Goiabeira","Goiana","Goiás","Gonçalves","Gonzaga","Gouvêia","Goya","Graça","Grajaú","Gramado","Granito","Granja","Granjeiro",
				"Gravatá","Greenfield","Greenville","Grossos","Guadalupe","Gualeguay","Guapé","Guapó","Guará","Guaraci","Guarani","Guarará",
				"Guariba","Guarujá","Guaxupé","Guidoval","Guimarães","Gulfport","Gurjão","Gussev","Geórgia","Goiás","Guanajuato","Guerrero","Gabão",
				"Gâmbia","Gana","Geórgia","Granada","Grécia","Guadalupe","Guatemala","Guiana","Guiné",
				"Hackensack","Hagerstown","Hamilton","Hamm","Hammond","Hamptons","Hannibal","Hanói","Hanôver","Harare","Harda","Haren","Harmonia",
				"Harrisburg","Hartford","Hassan","Hastings","Hattiesburg","Havana","Haverhill","Heitoraí","Helena","Heliodora","Heliópolis","Helsinque",
				"Hemer","Henderson","Herculândia","Hershey","Herval","Herveiras","Hialeah","Hickory","Hidrolândia","Hidrolina","Hilo","Hoboken","Holambra",
				"Halle","Hollywood","Holyoke","Homer","Honiara","Honolulu","Hoover","Hope","Hopkinsville","Horizonte","Horizontina","Horta","Hortolândia",
				"Houma","Houston","Huambo","Hubli","Humaitá","Huntington","Huntsville","Hutchinson","Hyères","Haryana","Havaí","Hesse","Hidalgo","Haiti",
				"Holanda","Honduras","Hungria",
				"Iacanga","Iacri","Iaçu","Iapu","Iaras","Iati","Ibaiti","Ibaté","Ibema","Ibiam","Ibicaraí","Ibicuí","Ibirá","Ibiraci","Ibirubá","Içara",
				"Icém","Ichim","Ichu","Iconha","Ieisk","Ielabuga","Ielets","Ielnia","Iepê","Igaci","Igaracy","Igarka","Iguaí","Ijaci","Ilhabela",
				"Ilhéus","Ilhota","Imaculada","Imbaú","Imigrante","Imperatriz","Inaciolândia","Inajá","Independence","Independência","Indiana","Indianápolis",
				"Indiara","Indiaroba","Ingá","Inhacorá","Inhapi","Inhuma","Inocência","Inta","Iomerê","Ipanema","Ipê","Ipiaú","Ipirá","Ipiranga",
				"Ipueiras","Iracema","Iraceminha","Irajuba","Iramaia","Irará","Irbit","Irvine","Istra","Itá","Itabaiana","Itacajá","Itacaruaré","Itagibá",
				"Itajubá","Italva","Itaóca","Itariri","Itaú","Ithaca","Itu","Ituzaingó","Iuiú","Iultin","Iúna","Ivaí","Ivanovo","Iacútia","Idaho",
				"Illinois","Imo","Indiana","Inguchétia","Iowa","Iêmen","Ilhas Solomão","Índia","Indonésia","Irã","Iraque","Irlznda","Islândia","Israel","Itália",
				"Jaboti","Jacarezinho","Jacarta","Jaci" ,"Jaciara","Jacinto","Jacksonville","Jacobina","Jacutinga","Jais","Jalgaon","Jambeiro","Jammu","Jandaia",
				"Jandira","Jangada","Japira","Jaqueira","Jardim","Jataí","Jatobá","Jaú","Jena","Jequitibá","Jericó","Jerusalém","Jesuítas","Jesús","Jóia",
				"Joliet","Jonesboro","Jordão","Joviânia","Juara","Juárez","Juazeiro","Juba","Jucás","Jucuruçu","Jundiá","Juneau","Junin","Juramento","Juranda",
				"Jurema","Juruaia","Juruena","Juruti","Juscimeira","Jussara","Jussiape","Jutaí","Juti","Juvenília","Jalisco","Jammu e Caxemira","Jharkhand",
				"Jigawa","Jonglei","Jujuy","Jura","Jamaica","Japão","Jersey","Jordânia",
				"Lábrea","Ladainha","Ladário","Lagarto","Lages","Lagoa","Lagoão","Lagoinha","Laguna","Laje","Lajeado","Lajedo","Lamim","Langen","Langley",
				"Lapão","Laranjal","Laranjeiras","Lastro","Lavandeira","Lavínia","Lavras","Lecce","Leer","Leh","Leme","Lençóis","Leopoldina","Liberdade",
				"Lille","Lima","Limeira","Limoeiro","Limpio","Lindóia","Linhares","Lins","Lisboa","Liubliana","Livramento","Loanda","Lobato","Londres",
				"Lontra","Lorena","Loreto","Lourdes","Luanda","Luca","Lucélia","Lucena","Luciara","Lucrécia","Ludhiana","Luminárias","Lupércio","Lusaka",
				"Lutécia","Luz","Lyon","Luisiana","Lara","Lagos","La Pampa","La Rioja","Laos","Látvia","Lesoto","Líbano","Libéria","Líbia","Lituânia","Luxemburgo",
				"Macaé","Macaíba","Macapá","Macaúbas","Machado","Macieira","Madalena","Madrid","Magda","Mairi","Majuro","Male","Malhada","Malhador","Malta","Mamonas",
				"Manaus","Manga","Manicoré","Mansidão","Mantena","Maracás","Maracanaú","Maranguape","Maratá","Maravilha","Marcação","Marco","Mari","Marialva",
				"Mariana","Maribondo","Maricá","Marilena","Marília","Marmeleiro","Marquinho","Martins","Maruim","Marzagão","Mascate","Mascote","Maseru","Mata",
				"Mateiros","Matina","Matrinchã","Mazagão","Medeiros","Medina","Meleiro","Mendes","Mercedes","Meridiano","Mesquita","Messias","Milagres","Milhã",
				"Mineiros","Mirabela","Mirador","Miranda","Mirante","Miraselva","Missal","Mococa","Modelo","Moeda","Moju","Manágua","Monróvia","Montadas","Montanha",
				"Montevidéo","Moreno","Mormaço","Morrinhos","Morros","Moscou","Mossoró","Motuca","Mucuri","Munhoz","Muqui","Murici","Mutum","Maranhão","Mérida",
				"Michigan","Michoacán","Minnesota","Miranda","Mississippi","Missouri","Montana","Morelos","Macau","Malásia","Mali","Malta","Marrocos","México",
				"Moçambique","Mônaco","Mongólia","Montenegro",
				"Nadiad","Nadim","Nagercoil","Nagold","Nainital","Nalgonda","Namibe","Nampa","Nanaimo","Nancy","Nandurbar","Nanital","Nantes",
				"Nanuque","Nápoles","Naque","Naranjal","Nashua","Nassau","Natal","Natalio","Natchez","Natércia","Natividade","Natuba","Naucalpan","Nauen","Naviraí",
				"Navsari","Nazaré","Nazária","Nazário","Neiva","Nellore","Nelson","Neman","Nettetal","Neuburg","Neuville","Nhamundá","Nice","Nicolet","Nidda","Ninheira",
				"Niterói","Nobres","Norden","Nordestina","Normal","Normandia","Normandin","Nottingham","Nouakchott","Novais","Novara","Novorizonte","Nucualofa","Nuporanga",
				"Nagaland","Nasarawa","Nayarit","Nebraska","Neuquén","Nevada","Níger","Nova Iorque","Nova Jérsei","Novo México","Namíbia","Nauru","Nepal","Nicarágua",
				"Níger","Nigéria","Niue","Noruega","Nova Caledônia","Nova Zelândia",
				"Oberá","Óbidos","Obligado","Ocala","Ocara","Odenthal","Odessa","Odivelas","Oeiras","Oelde","Offenburg","Ogden","Ojereli","Olaria","Óleo","Olímpia",
				"Olinda","Oliveira","Olpe","Ondjiva","Oneonta","Ongole","Ontário","Opelousas","Orai","Orange","Oratórios","Orem","Oriente","Orillia","Oriol","Orizona",
				"Orlando","Orleães","Orobó","Orocó","Orono","Orós","Oruro","Osasco","Oslo","Osório","Osterode","Ottawa","Ourém","Ouricuri","Ourinhos","Ourizona","Ouro",
				"Ouroeste","Ouvidor","Ovar","Oxford","Oziori","Oaxaca","Obwald","Ogun","Ohio","Oklahoma","Ondo","Oregon","Orissa","Osun","Oyo","Omã",
				"Pacaembu","Pacajá","Pacajus","Pacoti","Pacujá","Paial","Painel","Paiva","Palestina","Palhoça","Palmas","Palmeiras","Palmelo","Palmital","Panamá","Pancas",
				"Panelas","Panorama","Papagaios","Paraíso","Paramaribo","Paraty","Pardinho","Parecis","Pariconha","Paripueira","Paris","Parisi","Passagem","Passos","Patos",
				"Patrocínio","Patu","Paudalho","Paulista","Pavão","Peabiru","Peçanha","Pedra","Pedreira","Peixe","Pelotas","Penaforte","Penha","Pentecoste","Pequi","Pequim",
				"Pequizeiro","Perdizes","Perdões","Pereiras","Periquito","Perobal","Pérola","Pesqueira","Piau","Picos","Picuí","Piedade","Piên","Pilar","Pilões","Pimenta",
				"Pindaí","Pinhão","Pinheiro","Pintadas","Piquete","Piracema","Piranhas","Pirapó","Piraquê","Piripiri","Pitanga","Pitangueiras","Placas","Planalto","Platina",
				"Poá","Poção","Pocinhos","Poções","Podgorica","Pombos","Pontão","Portão","Porteirinha","Posse","Poté","Potim","Pracinha","Prainha","Prata","Pretória",
				"Primavera","Princesa","Progresso","Pureza","Putinga","Pará","Paraíba","Paraná","Pensilvânia","Pernambuco","Piauí","Plateau","Portuguesa","Puebla","Punjabe",
				"Palau","Panamá","Paquistão","Paraguai","Peru","Polônia","Porto Rico","Portugal",
				"Quadra","Quakenbrück","Quaraí","Quarteira","Quatá","Quatiguá","Quatipuru","Quatis","Quebec","Quebrangulo","Quedlimburgo","Queimadas","Queimados","Queiroz",
				"Queluz","Queluzito","Quequén","Querência","Querétaro","Querfurt","Quesnel","Quevedos","Quíbor","Quickborn","Quiindy","Quijingue","Quillacollo","Quilombo",
				"Quincy","Quintana","Quipapá","Quirinópolis","Quissamã","Quitandinha","Quiterianópolis","Quito","Quixaba","Quixabeira","Quixadá","Quixelô","Quixeramobim",
				"Quixeré","Quyquyhó","Querétaro de Arteaga","Quintana Roo","Qatar","Quirguistão",
				"Rafard","Raleigh","Ramilândia","Rancharia","Raposa","Raposos","Realeza","Rebouças","Recife","Recreio","Redenção","Redentora","Reduto","Regeneração",
				"Registro","Relvado","Remanso","Renascença","Resende","Reserva","Resplendor","Ressaquinha","Restinga","Revere","Riachão","Riachinho","Riachuelo","Rialma",
				"Rialto","Ribeira","Ribeirão","Rifaina","Riga","Rincão","Riozinho","Riqueza","Riverside","Rochedo","Rochester","Rockford","Rodeio","Rodeiro","Rodelas",
				"Rolador","Rolante","Roma","Romaria","Roncador","Rondinha","Rondon","Rosana","Rosário","Roseau","Roseira","Roteiro","Rubelita","Rubim","Rubinéia","Russas",
				"Ruston","Rajastão","Renânia-Palatinado","Rhode Island","Rio de Janeiro","Rio Grande do Norte","Rio Grande do Sul","Río Negro","Rivers","Rondônia","Roraima",
				"República Tcheca","Romênia","Ruanda","Rússia",
				"Sabino","Saboeiro","Sacramento","Salem","Sales","Salete","Salgadinho","Salgado","Salgueiro","Salinas","Salitre","Salta","Saltinho","Salto","Salvador",
				"Salvaterra","Sambaíba","Sampaio","Sana","Santaluz","Santana","Santarém","Santiago","Santos","Sapé","Sapezal","Sapucaia","Sarasota","Satara","Satuba",
				"Saudades","Saúde","Seara","Segredo","Selma","Sem-Peixe","Senador Pompeu","Seridó","Seringueiras","Sério","Serra","Serrana","Serrania","Serranos",
				"Serraria","Serrinha","Serrita","Serro","Sertaneja","Sertão","Sertãozinho","Seul","Sevilha","Silvânia","Silveiras","Silves","Simões","Sinop","Siracusa",
				"Siriri","Slidell","Sobrado","Sobral","Socorro","Sófia","Soledade","Solidão","Sombrio","Sonora","Sorocaba","Sorriso","Sossêgo","Sousa","Sucupira",
				"Sumidouro","Surat","Surrey","Surubim","Sussuapara","Suva","Suzano","Storrs","São Paulo","Sergipe","Sarre","Saxônia","Sonora","Sinaloa","Sucre","Sikkim",
				"Sokoto","San Marino","Senegal","Serra Leoa","Sérvia","Síria","Somália","Sudão","Suécia","Suíça","Suriname",
				"Tabuleiro","Tacaimbó","Tailândia","Taiobeiras","Taió","Talismã","Tamandaré","Tamboril","Tandil","Tanquinho","Tapera","Tapira","Taquara","Taquaral",
				"Tarabai","Tarrafas","Tarragona","Tarumã","Tashkent","Tatuí","Taunton","Tavares","Tbilisi","Tefé","Tegucigalpa","Teixeira","Telha","Tenali","Tenório",
				"Terenos","Teresina","Terezinha","Terrace","Tesouro","Teutônia","Thane","Tibau","Tietê","Tigre","Tigrinhos","Tijucas","Timbó","Timmins","Timon","Timóteo",
				"Timphu","Tiradentes","Tiros","Tocantínia","Toledo","Tombos","Torixoréu","Torres","Torrinha","Toulon","Toulouse","Touros","Towson","Trail","Trairão","Trairi",
				"Travesseiro","Tremedal","Tremembé","Trenton","Trindade","Trinidad","Triunfo","Trombas","Trujui","Tubarão","Tucano","Tucumã","Tunas","Tunis","Tupã","Tupelo",
				"Turvânia","Turvo","Tutóia","Tocantins","Turíngia","Tlaxcala","Tabasco","Texas","Tennessee","Tripura","Táchira","Trujillo","Taraba","Tadjiquistão","Tailândia",
				"Taiwan","Tanzânia","Timor Leste","Togo","Tonga","Tunísia","Turquia","Tuvalu",
				"Uarini","Uauá","Ubá","Ubajara","Ubatã","Ubatuba","Uberaba","Uberlândia","Ubirajara","Ubiratã","Uchoa","Údine","Uelzen","Ufa","Uibaí","Uíge","Uiraúna","Ujjain",
				"Ulm","Umari","Umarizal","Umbaúba","Umbuzeiro","Umirim","Una","União","Uniflor","Unión","Unistalda","Unna","Unnao","Upanema","Upata","Uraí","Urandi","Urânia",
				"Urbana","Urdinarrain","Uren","Urjum","Uru","Uruaçu","Uruana","Urubici","Urucânia","Urucará","Urucuia","Uruoca","Urupema","Urussanga","Urutaí","Uslar","Utica",
				"Utinga","Uyuni","Uzlovaia",
				"Vacaria","Vaduz","Valdez","Valença","Valente","Valetta","Valinhos","Valladolid","Valparaíso","Vancouver","Vanini","Vapi","Vargeão","Vargem","Varginha","Varjão",
				"Varjota","Varre-Sai","Varsóvia","Várzea","Varzedo","Vassouras","Vazante","Vellore","Venha-Ver","Ventania","Venturosa","Vera","Verdejante","Verê","Vereda",
				"Veredinha","Veríssimo","Vernon","Vertentes","Vespasiano","Viadutos","Viamão","Viana","Vicência","Vicentina","Viçosa","Victoria","Videira","Vieiras","Viena",
				"Vietiane","Vigia","Vilhena","Vilnius","Vinhedo","Viradouro","Virar","Virgínia","Virgolândia","Virmond","Vitória","Vitorino","Viseu","Votorantim","Valais",
				"Vargas","Vaud","Veracruz","Vermont","Viena","Virgínia","Virgínia Ocidental","Vorarlberg","Vanuatu","Vaticano","Venezuela","Vietnã",
				"Zabelê","Zacarias","Zacatecas","Zacatepec","Zacazonapan","Zacualpan","Zagreb","Zapopan","Zapotiltic","Zapotlanejo","Zaragoza","Zaraisk","Zaraza","Zé Doca",
				"Zehdenick","Zeitz","Zelenodolsk","Zelenograd","Zelenogradsk","Zentla","Zerbst","Zihuatanejo","Zinacantán","Zinacantepec","Zirándaro","Zirndorf","Zitlala",
				"Zittau","Zlatoiust","Zongolica","Zontecomatlán","Zortéa","Zossen","Zucualpan","Zugo","Zülpich","Zumpahuacán","Zumpango","Zurique","Zvenigorod","Zweibrücken",
				"Zwickau","Zacatecas","Zulia","Zamfara","Zurique","Zugo","Zâmbia","Zimbábue",
		};

		return palavras;}
	
	private static String[] getObjetos(){
		String respostasObjetos[] = {
				"Ábaco","Abafador","Abajur","Abraçadeira","Abre-latas","Acordeão","Açucareiro","Adaga","Adaptador","Aerofólio",
				"Afoxé", "Agenda", "Agogô", "Agulha","Agulheiro","Alarme","Alaúde","Álbum","Aldrava","Alfinete","Alforje",
				"Algema","Algodão","Alicate","Alidade","Aljava","Almofada","Almofariz","Alto falante","Amortecedor","Ampulheta",
				"Amuleto","Âncora","Andador","Andaime","Anilha","Antena","Antolho","Anzol","Apagador","Aparador","Apito",
				"Apontador de lápis","Aquário","Aquecedor","Arco","Armadilha","Armadura","Armário","Aro","Arpão","Arruela",
				"Artroscópio","Asa delta","Aspirador","Assadeira","Astrógrafo","Astrolábio","Autorama","Azulejo",
				"Bafômetro","Bagageiro","Baioneta","Baixo","Balaclava","Balaio","Balalaika","Balança","Balão","Balaústre","Baleiro",
				"Balsa","Bambolê","Banco","Bandana","Bandeira","Bandola","Bandolim","Bandoneon","Banjo","Banqueta","Baqueta",
				"Barbante","Barraca","Barril","Basculante","Base","Bastão","Bata","Batá","Batedeira","Batente","Bateria","Batina",
				"Batom","Batuta","Baú","Bazuca","Beca","Beliche","Bengala","Berço","Berimbau","Betoneira","Bíblia","Bicama",
				"Bidê","Bigorna","Binóculo","Biruta","Bisturi","Bóia","Bola","Bomba de Óleo","Bombarda","Boneca","Bongô","Botão",
				"Botina","Brinco","Broca","Bucha","Bule","Bumerangue","Buzina",
				"Cabide","Caçarola","Cachimbo","Cadeado","Cadeira","Caderno","Cafeteira","Caixão","Cajado","Caldeirão","Calibrador",
				"Cálice","Cama","Candeeiro","Candelabro","Caneca","Caneleira","Caneta","Canga","Canivete","Cantil","Capa","Capacete",
				"Cápsula","Carimbo","Carregador","Carretel","Cartão","Carteira","Castanholas","Castiçal","Catavento","Catraca","Cavalete",
				"Cavaquinho","Cd","Celular","Cesta","Chaleira","Chapéu","Charuto","Chave","Chicote","Chinelo","Chip","Chocalho","Chupeta",
				"Chuteira","Chuveiro","Clip","Coador","Cofre","Colchão","Coleira","Colher","Cômoda","Compasso","Concha","Cone","Contrabaixo",
				"Corneta","Crachá","Crucifixo","Cutelo",
				"Dado","Dardo","Dedal","Delineador","Depilador","Depósito de Ommaya","Desentupidor","Desfibrilador","Desinfetante","Desodorante",
				"Despertador","Desumidificador","Detector","Detergente","Diabolo","Diamante","Diário","Didjeridu","Disco","Disquete","Divã","Dobro",
				"Dominó","Draga","Dreidel","Drums","Duduk","Dulçaina","Dulciana","Dulcimer","Duto","Dvd","DVR",
				"Echarpe","Edredom","Eixo","Elástico","Elevador","Elmo","Embreagem","Enceradeira","Engate","Engrenagem","Envelope","Enxada","Escada",
				"Escapamento","Escavadeira","Escopeta","Escorredor","Escorregador","Escova","Escudo","Escumadeira","Esfera","Esfigmomanômetro","Esfregão",
				"Esmalte","Espaçador","Espada","Espadrilha","Espanador","Esparadrapo","Espartilho","Espátula","Espelho","Espeto","Espineta","Espingarda",
				"Espiral","Espirógrafo","Esponja","Espremedor","Esquadro","Estabilizador","Estaca","Estandarte","Estator","Estátua","Esteira","Estetoscópio",
				"Estilete","Estilingue","Estojo","Estribo","Etiqueta","Eufônico","Eufônio","Exaustor","Expansor","Extintor",
				"Faca","Facão","Fagote","Fantasia","Fantoche","Faqueiro","Farda","Farinheiro","Farol","Farolete","Fax","Feliscorne","Ferradura","Ferramenta",
				"Ferro de passar","Ferrolho","Ferrorama","Fibra","Fichário","Figurinha","Filmadora","Filtro","Fio","Fita","Fivela","Fixador","Flanela",
				"Flâmula","Flauta","Flautim","Flecha","Fliscorne","Flugelhorn","Focinheira","Fogão","Foguete","Foice","Fórceps","Forma","Formão","Forno",
				"Frasco","Frasqueira","Freezer","Freio","Frigideira","Frigobar","Fritadeira","Fronha","Fruteira","Fulannu","Funda","Funil","Furadeira",
				"Fusível","Fuzil",
				"Gabinete","Gaiola","Gaita","Galheteiro","Galocha","Gancho","Gangorra","Ganzá","Garfo","Gargantilha","Garrafa","Gashapon","Gatorra","Gaveta",
				"Gaxeta","Geladeira","Gel","Geleca","Geomag","Gesso","Gibi","Giz","Glockenspiel","Gloss","Gogos","Goma","Gorro","Gramofone","Grampeador",
				"Grampo","Granada","Gravata","Graxeta","Grelha","Grinalda","Grua","Guarda-barro","Guarda-chuva","Guarda-roupa","Guarda-sol","Guardanapo","Guardapolvo",
				"Guia de cabo","Guia de garfo","Guia de válvula","Guia grampo","Guidão","Guidom","Guilhotina","Guirlanda","Guitarra",
				"Halímetro","Haltere","Harmônio","Harmonizador","Harmonógrafo","Harpa","Hárpaga","Haste","Helépolis","Hélice","Helicóptero","Helícula","Heliômetro",
				"Helioscópio","Helióstato","Hematímetro","Hemocitômetro","Hemodinamômetro","Hidrante","Hidratante","Hidroavião","Hidrômetro",
				"Higrômetro","Hipômetro","Hodômetro","Hojok","Holofote","Home theater","Horquilla","Hóstia",
				"Iate","Ictiômetro","Igaçaba","Igarité","Ignitor","Ilho de borracha","Ímã","Impressora","Inalador","Incenso","Ingresso","Injetor","Interfone",
				"Interruptor","Ioiô","Isolador","Isqueiro",
				"Jaleco","Janela","Jangada","Jaqueta","Jardineira","Jarra","Jarro","Jato","Jaula","João bobo","Joelheira","Joelho hidráulico",
				"Jogo da memória","Jogo de anéis","Jogo de damas","Jogo de sapata","Jóia","Jornal","Joystick","Jumelo","Junção de mangueira",
				"Junção do carburador","Junta de vedação","Junta do cabeçote",
				"Laço","Lacre","Lã de aço","Lajota","Lâmina","Lâmpada","Lamparina","Lampião","Lança","Lança-granada","Lancetador","Lanceta","Lancheira",
				"Lantejoula","Lanterna","Lápis","Lapiseira","Laquê","Laringoscopio","Lata","Lava-arroz","Lava-louças","Leiteira","Leitor de Dvd",
				"Leme","Lenço","Lençol","Lente","Leque","Língua de sogra","Liquidificador","Litotriptor","Livro","Lixa de unha","Lixadeira","Lixeira",
				"Lona","Longarina","Louça","Lousa","Luminária","Luneta","Lustre","Luva","Luva de boxe","Luva pvc",
				"Maca","Macaco hidráulico","Maçaneta","Maçarico","Machado","Maiô","Mala","Maleiro","Malhete","Mamadeira","Mandolina","Manequim",
				"Mangueira","Manivela","Manta","Maquete","Máquina de costura","Máquina eletrostática","Máquina fotográfica","Maracá","Marca-passo",
				"Marcador de página","Marimba","Marionete","Marreta","Martelo","Máscara de mergulho","Máscara de oxigênio","Mastro",
				"Matraca","Medalha","Megafone","Meia","Meia calça","Melofone","Mesa","Metralhadora","Miçanga","Micro-ondas","Microfone",
				"Microscópio","Mimeógrafo","Minissaia","Míssil","Misturador","Mochila","Modem","Moeda","Mola","Molheira","Molinete","Monitor",
				"Monóculo","Moodswinger","Mosquiteiro","Motor","Mouse","Multiprocessador","Munhequeira","Mural",
				"Nadadeira","Narguilé","Navalha","Nave espacial","Naveta","Navio","Nebulizador","NeoCube","Netbook","Neutralizador de odores",
				"Ney","Niple","Nónio","Notebook","Novelo",
				"Oboé","Ocarina","Octante","Óculos","Odômetro","Odontoscópio","Odre","Oficleide","Oftalmoscópio","Ofurô","Olho mágico",
				"Ombreira","Orelhão","Órgão","Osteótomo","Otoscópio","Oxigenador","Oxímetro",
				"Pá","Palete","Paletó","Palheta","Paliteiro","Palmilha","Pandeiro","Panela","Pano","Pantufa","Papel","Papete","Papiro","Para-raios",
				"Parabrisa","Parafina","Parafuso","Paraquedas","Pasta","Patinete","Pedal","Pendrive","Pêndulo","Peneira","Pente","Penteadeira",
				"Perfume","Pergaminho","Periscópio","Persiana","Peruca","Peteca","Pia","Piano","Picareta","Piercing","Pilão","Pinça","Pincel",
				"Pingente","Pino","Pipa","Pipeta","Pipoqueira","Pires","Pistola","Placa","Pneu","Pochete","Podadeira","Podão","Poltrona","Poncheira",
				"Ponteiro","Porta","Pote","Prancha","Prateleira","Prato","Pregador","Presilha","Projétil","Pulseira","Pulverizador","Punhal","Puxador",
				"Quadrante de Davis","Quadriciclo","Quadriton","Quadro","Quadro de bicicleta","Quadro negro","Quebra-cabeça","Quebra-nozes","Queijeira",
				"Quena","Quepe","Quimono","Quinticlave",
				"Rebab","Rabeca","Rabeta","Rabicho","Rack","Radar","Rádio","Rádio comunicador","Raio de bicicleta","Ralador","Ralo","Ralo seco","Ramalhete",
				"Raquete","Rasteirinha","Rastelo","Ratoeira","Rebite","Rebolo","Reco-reco","Rede","Rédea","Refletor","Régua","Relé","Relicário","Relógio",
				"Remo","Repelente","Repinique","Requinta","Resta-um","Retentor","Retificador","Retrato","Retroprojetor","Retrovisor","Revista","Revisteiro",
				"Revólver","Rifle","Rímel","Rinoscópio","Roda","Rodapé","Rodo","Roladeira","Rolamento","Rolha","Rolo de massa","Rolo de pintura","Roomba",
				"Roteador","Rotor",
				"Sabão barra","Sabonete","Saboneteira","Sabre","Sabre motosserra","Saca-rolhas","Sacabuxa","Saco","Sacola","Saia","Saladeira","Saleiro",
				"Saltério de Arco","Samba canção","Samovar","Sampler","Sandália","Sanduicheira","Sanfona","Sapateira","Sapatilha","Sapato","Sarrusofone",
				"Saxofone","Saxotrompa","Scanner","Secador","Secadora","Selim","Semáforo","Seringa","Serpentina","Serra","Serrote","Sextante","Short",
				"Silênciador","Sinalizador","Sino","Sinos tubulares","Sintetizador","Sirene","Skate","Smoking","Soco inglês","Sofá","Sombrero","Sombrinha",
				"Sonda hidrofílica","Sonda nasogástrica","Sorveteira","Spray","Suéter","Sunga","Suona","Suporte para TV","Suspensório","Sutiã",
				"Tábua","Tabuleiro","Taça","Talher","Tamanco","Tamagotchi","Tambor","Tamborete","Tamborim","Tampa","Tanque","Tapete","Tarracha","Tatame",
				"Tear","Teasmade","Tecido","Teclado","Tela","Telefone","Telescópio","Televisão","Telha","Tênis","Termômetro","Termostato","Terno","Terrina",
				"Tesoura","Tiara","Tigela","Tijolo","Toalha","Tobogã","Toga","Toldo","Tonel","Torneira","Tornozeleira","Torpedo","Torquetum","Torradeira",
				"Touca","Trampolim","Transferidor","Trave","Travesseiro","Triciclo","Tridente","Triquetrum","Triturador","Troféu","Trombone","Trompa","Trompete",
				"Trono","Trotinete","Tuba","Tubo pvc","Túnica","Turbante","Turbina",
				"Udógrafo","Ukulele","Ultrabook","Ultraleve","Umidificador","Unha postiça","Uniforme","Urdideira","Ureteroscópio","Urinol","Urna","Urso de pelúcia",
				"Vajra","Válvula de escape","Válvula termiônica","Válvula ventosa","Vaporizador","Vara de pesca","Varal","Vareta de freio","Vareta de solda",
				"Vaso","Vaso sanitário","Vassoura","Vedador anaeróbico","Vela de cera","Vela de ignição","Veleiro","Velocímetro","Ventilador","Verruma",
				"Vestido","Véu","Véu do cálice","Vibrador","Vibrafone","Vídeo cassete","Vídeo game","Vidro de relógio","Viola","Violão","Violbass acústico","Violino",
				"Violoncelo","Virabrequim","Viscosímetro","Viseira","Vitrola","Volante","Voltímetro","Vuvuzela",
				"Zabumba","Zabuton","Zafu","Zamproña","Zarabatana","Zíper","Zootropo"};
		return respostasObjetos;
	}

	
	private static int getPontos(String[] respostas, char letra) {
		int pontos = 0;
		String nome = respostas[0];
		String lugar = respostas[1];
		String objeto = respostas[2];

		String[] lugares = getLugares();
		String[] objetos = getObjetos();

		if (nome.charAt(0) == letra && nome.length() >= 3) {
			pontos += 10;
		}

		if (lugar.charAt(0) == letra && Arrays.asList(lugares).contains(lugar)) {
			pontos += 10;
		}

		if (objeto.charAt(0) == letra &&  Arrays.asList(objetos).contains(objeto)) {
			pontos += 10;
		}

		return pontos;
	}

	public static void main(String[] args) throws IOException {

		try {
			new Servidor().executar();
		}
		catch(Throwable t) {
			t.printStackTrace();
		}

	}

	public void executar() throws IOException {
		ServerSocket s = new ServerSocket(60000);
		executando = true;
		System.out.println("Servidor iniciado! \n");
		letra = gerarLetra();

		while(executando) {
			processar(s.accept());
		}
		s.close();
	}

	public void processar(final Socket conexao) {
		Runnable execucao = new Runnable() {

			public void run() {
				try {
					System.out.println("Cliente conectado");

					BufferedReader buf = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
					ObjectInputStream input = new ObjectInputStream(conexao.getInputStream());
					DataOutputStream output = new DataOutputStream(conexao.getOutputStream());

					String nomeCliente = buf.readLine();
					System.out.println("Seja bem-vindo(a) "+nomeCliente);

					int pontos;
					String letra_enviada = letra + "\n";
					output.writeBytes(letra_enviada);
					output.flush();
					Object object = input.readObject();
					String[] respostas;
					respostas = (String[])object;
					pontos = getPontos(respostas, letra);
					System.out.println("Respostas do jogador(a) "+nomeCliente);
					
					if(respostas[0].charAt(0) == letra && respostas[0].length() >= 3)
						System.out.println(respostas[0]+": válida.");
					else
						System.out.println(respostas[0]+": inválida.");
					
					if(respostas[1].charAt(0) == letra && Arrays.asList(getLugares()).contains(respostas[1]))
						System.out.println(respostas[1]+": válida.");
					else
						System.out.println(respostas[1]+": inválida.");
					
					if(respostas[2].charAt(0) == letra && Arrays.asList(getObjetos()).contains(respostas[2]))
						System.out.println(respostas[2]+": válida.");
					else
						System.out.println(respostas[2]+": inválida.");
						
					System.out.println("O(A) jogador(a) "+nomeCliente+" fez "+pontos+" pontos");
				}
				catch(IOException e) {
					e.printStackTrace();
				} 
				catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}

		};

		new Thread(execucao).start();
	}
}
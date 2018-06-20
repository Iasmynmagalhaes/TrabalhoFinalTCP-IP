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
				"Abati�","Abeba","Acari","Acegu�","Acra","A�u","Adis","Adolfo","Afr�nio","Agrestina","Agudos","Albertina","Alecrim",
				"Alegre","Alian�a","Almas","Altair","Altamira","Altinho","Altos","Am�","Americana","Amontada","Amparo","Amp�re","Anahy",
				"Anan�s","Anast�cio","Ancara","Ang�lica","Angical","Antas","Aracruz","Arame","Arara","Araras","Arco-�ris","Arcos","Areado",
				"Areal","Areia","Argel","Ariranha","Aroeiras","Assa�","Assun��o","Astana","Atenas","Aurora","Ava�","Acre","Alagoas",
				"Amap�","Amazonas","Alabama","Alasca","Arizona","Altai","Afeganist�o","Alb�nia","Alemanha","Angola","Arg�lia","Argentina",
				"Arm�nia","Austr�lia","�ustria","Azerbaij�o",
				"Bacuri","Bagd�","Bagre","Bai�o","Baku","Baldim","Baliza","B�lsamo","Balsas","Bananal","Bananeiras","Bandeira","Bangcoc",
				"Bangui","Banjul","Bar�o","Bara�na","Barcelona","Barra","Barrac�o","Barreira","Barreiros","Barrinha","Barro","Barroso",
				"Basseterre","Batalha","Batatais","Bebedouro","Beirute","Bel�m","Bet�nia","Bezerros","Bicas","Biquinhas","Bod�","Bofete",
				"Bombinhas","Bonfim","Bonito","Bozano","Braga","Branquinha","Bra�na","Brazzaville","Brejo","Brotas","Bugre","Buritis",
				"Buritizeiro","Bahia","Baixa Calif�rnia do Sul","Baixa Calif�rnia","Bahamas","Barbados","Belarus","B�lgica","Bermudas",
				"Bol�via","Brasil","Brunei","Bulg�ria","But�o",
				"Caatiba","Cabaceiras","Cabeceiras","Cabixi","Cabrob�","Cabul","Ca�ador","C�ceres","Cachoeira","Cacimbas","Cacul�","Cafarnaum",
				"Caiana","Cairo","Cajazeiras","Cajueiro","Cal�ado","Caldas","Calif�rnia","Camberra","Cambira","Camet�","Campanha","Campestre",
				"Campinas","Cana�","Canas","Candel�ria","Canela","Cant�","Cantagalo","Canudos","Capela","Capim","Capit�o","Capixaba","Cara�",
				"Caracas","Caracol","Cara�","Carazinho","Cardoso","Careiro","Caridade","Carmo","Carneiros","Carolina","Carrancas","Casca",
				"Cascavel","Casinhas","Castelo","Castries","Catarina","Cavalcante","Cedro","Ch�cara","Chal�","Chaves","Cidreira","Cip�","Cl�udia",
				"Cl�udio","Colombo","Comodoro","Conacri","Conc�rdia","Conde","Congo","Copenhagem","Coxim","Cristal","Cristina","Croat�","Cruz",
				"Cruzeta","Cuit�","Cunha","Cupira","Curimat�","Currais","Curu�","Cutias","Campeche","Cear�","Chiapas","Chihuahua","Coahuila","Colima",
				"Calif�rnia","Colorado","Camar�es","Camboja","Canad�","Cazaquist�o","Chile","China","Cingapura","Col�mbia","Congo","Cuba",
				"Dacca","Dakar","Dallas","Dalton","Damasco","Dami�o","Damol�ndia","Danilov","Danville","Darlington","Datas","Dayton","Dearborn",
				"Decatur","Delta","Deltona","Demopolis","Denise","Denton","Denver","Derrubadas","Descalvado","Descanso","Descoberto","Desterro",
				"Detroit","Diadema","Diamante","Dickinson","Digora","Dion�sio","Divino","Divin�polis","Dno","Dobrada","Dodoma","Doha","Dormentes",
				"Douglas","Dourado","Dourados","Dover","Downey","Dracena","Duartina","Dublin","Dubna","Dubuque","Duer�","Duluth","Dumont",
				"Dundalk","Durango","Durham","Daguest�o","Dakota do Norte","Dakota do Sul","Delaware","Distrito de Col�mbia","Distrito Federal",
				"Durango","Dinamarca","Djibuti","Dominica",
				"Ecoporanga","Edealina","Ed�ia","Edmond","Eldorado","Elektrostal","Elisi�rio","Elista","Elko","Elsmere","Emas","Emba�ba","Encantado",
				"Encanto","Encruzilhada","Engels","Enid","Envira","Equador","Erechim","Erer�","Erevan","Erie","Ermo","Ernestina","Erv�lia","Escada",
				"Escondido","Esmeralda","Esmeraldas","Esperan�a","Espinosa","Esplanada","Espumoso","Esquel","Esta��o","Est�ncia","Esteio","Estiva",
				"Estocolmo","Estreito","Estrela","Eufaula","Eugene","Eureka","Eus�bio","Evanston","Everett","Extrema","Exu","Entre R�os","Esp�rito Santo",
				"Egito","El Salvador","Equador","Eritr�ia","Eslov�quia","Eslov�nia","Espanha","Estados Unidos","Est�nia","Eti�pia",
				"Fachinal","Fagundes","Faina","Fairfax","Fallon","Fama","Fargo","Faro","Farol","Fartura","F�tima","Faxinal","Feij�","Feliz","F�nix",
				"Fern�o","Ferreiros","Ferros","Fervedouro","Figueira","Filad�lfia","Flexeiras","Flora�","Floreal","Florence","Flores","Floresta",
				"Florestal","Floriano","Fl�rida","Formiga","Formosa","Formoso","Forquilha","Fortaleza","Fortim","Fortuna","Franca","Frankfort",
				"Franklin","Frecheirinha","Frederick","Freeport","Freetown","Fremont","Fresno","Friazino","Frolovo","Fronteira","Frutal","Fullerton",
				"Fulton","Funafuti","Fund�o","Fund�o","Funil�ndia","Fl�rida","Formosa","Fiji","Filipinas","Finl�ndia","Fran�a",
				"Gaborone","Gagarin","Galesburg","G�lia","Galileia","Galinhos","Galv�o","Gameleira","Gameleiras","Gandu","Gar�a","Gardner","Garibaldi",
				"Garup�","Gary","Gaspar","Gastonia","Gavi�o","Geminiano","Gentil","Georgetown","Getulina","Gilbert","Glendale","Glic�rio","Gl�ria",
				"Glorinha","Goiabeira","Goiana","Goi�s","Gon�alves","Gonzaga","Gouv�ia","Goya","Gra�a","Graja�","Gramado","Granito","Granja","Granjeiro",
				"Gravat�","Greenfield","Greenville","Grossos","Guadalupe","Gualeguay","Guap�","Guap�","Guar�","Guaraci","Guarani","Guarar�",
				"Guariba","Guaruj�","Guaxup�","Guidoval","Guimar�es","Gulfport","Gurj�o","Gussev","Ge�rgia","Goi�s","Guanajuato","Guerrero","Gab�o",
				"G�mbia","Gana","Ge�rgia","Granada","Gr�cia","Guadalupe","Guatemala","Guiana","Guin�",
				"Hackensack","Hagerstown","Hamilton","Hamm","Hammond","Hamptons","Hannibal","Han�i","Han�ver","Harare","Harda","Haren","Harmonia",
				"Harrisburg","Hartford","Hassan","Hastings","Hattiesburg","Havana","Haverhill","Heitora�","Helena","Heliodora","Heli�polis","Helsinque",
				"Hemer","Henderson","Hercul�ndia","Hershey","Herval","Herveiras","Hialeah","Hickory","Hidrol�ndia","Hidrolina","Hilo","Hoboken","Holambra",
				"Halle","Hollywood","Holyoke","Homer","Honiara","Honolulu","Hoover","Hope","Hopkinsville","Horizonte","Horizontina","Horta","Hortol�ndia",
				"Houma","Houston","Huambo","Hubli","Humait�","Huntington","Huntsville","Hutchinson","Hy�res","Haryana","Hava�","Hesse","Hidalgo","Haiti",
				"Holanda","Honduras","Hungria",
				"Iacanga","Iacri","Ia�u","Iapu","Iaras","Iati","Ibaiti","Ibat�","Ibema","Ibiam","Ibicara�","Ibicu�","Ibir�","Ibiraci","Ibirub�","I�ara",
				"Ic�m","Ichim","Ichu","Iconha","Ieisk","Ielabuga","Ielets","Ielnia","Iep�","Igaci","Igaracy","Igarka","Igua�","Ijaci","Ilhabela",
				"Ilh�us","Ilhota","Imaculada","Imba�","Imigrante","Imperatriz","Inaciol�ndia","Inaj�","Independence","Independ�ncia","Indiana","Indian�polis",
				"Indiara","Indiaroba","Ing�","Inhacor�","Inhapi","Inhuma","Inoc�ncia","Inta","Iomer�","Ipanema","Ip�","Ipia�","Ipir�","Ipiranga",
				"Ipueiras","Iracema","Iraceminha","Irajuba","Iramaia","Irar�","Irbit","Irvine","Istra","It�","Itabaiana","Itacaj�","Itacaruar�","Itagib�",
				"Itajub�","Italva","Ita�ca","Itariri","Ita�","Ithaca","Itu","Ituzaing�","Iui�","Iultin","I�na","Iva�","Ivanovo","Iac�tia","Idaho",
				"Illinois","Imo","Indiana","Inguch�tia","Iowa","I�men","Ilhas Solom�o","�ndia","Indon�sia","Ir�","Iraque","Irlznda","Isl�ndia","Israel","It�lia",
				"Jaboti","Jacarezinho","Jacarta","Jaci" ,"Jaciara","Jacinto","Jacksonville","Jacobina","Jacutinga","Jais","Jalgaon","Jambeiro","Jammu","Jandaia",
				"Jandira","Jangada","Japira","Jaqueira","Jardim","Jata�","Jatob�","Ja�","Jena","Jequitib�","Jeric�","Jerusal�m","Jesu�tas","Jes�s","J�ia",
				"Joliet","Jonesboro","Jord�o","Jovi�nia","Juara","Ju�rez","Juazeiro","Juba","Juc�s","Jucuru�u","Jundi�","Juneau","Junin","Juramento","Juranda",
				"Jurema","Juruaia","Juruena","Juruti","Juscimeira","Jussara","Jussiape","Juta�","Juti","Juven�lia","Jalisco","Jammu e Caxemira","Jharkhand",
				"Jigawa","Jonglei","Jujuy","Jura","Jamaica","Jap�o","Jersey","Jord�nia",
				"L�brea","Ladainha","Lad�rio","Lagarto","Lages","Lagoa","Lago�o","Lagoinha","Laguna","Laje","Lajeado","Lajedo","Lamim","Langen","Langley",
				"Lap�o","Laranjal","Laranjeiras","Lastro","Lavandeira","Lav�nia","Lavras","Lecce","Leer","Leh","Leme","Len��is","Leopoldina","Liberdade",
				"Lille","Lima","Limeira","Limoeiro","Limpio","Lind�ia","Linhares","Lins","Lisboa","Liubliana","Livramento","Loanda","Lobato","Londres",
				"Lontra","Lorena","Loreto","Lourdes","Luanda","Luca","Luc�lia","Lucena","Luciara","Lucr�cia","Ludhiana","Lumin�rias","Lup�rcio","Lusaka",
				"Lut�cia","Luz","Lyon","Luisiana","Lara","Lagos","La Pampa","La Rioja","Laos","L�tvia","Lesoto","L�bano","Lib�ria","L�bia","Litu�nia","Luxemburgo",
				"Maca�","Maca�ba","Macap�","Maca�bas","Machado","Macieira","Madalena","Madrid","Magda","Mairi","Majuro","Male","Malhada","Malhador","Malta","Mamonas",
				"Manaus","Manga","Manicor�","Mansid�o","Mantena","Marac�s","Maracana�","Maranguape","Marat�","Maravilha","Marca��o","Marco","Mari","Marialva",
				"Mariana","Maribondo","Maric�","Marilena","Mar�lia","Marmeleiro","Marquinho","Martins","Maruim","Marzag�o","Mascate","Mascote","Maseru","Mata",
				"Mateiros","Matina","Matrinch�","Mazag�o","Medeiros","Medina","Meleiro","Mendes","Mercedes","Meridiano","Mesquita","Messias","Milagres","Milh�",
				"Mineiros","Mirabela","Mirador","Miranda","Mirante","Miraselva","Missal","Mococa","Modelo","Moeda","Moju","Man�gua","Monr�via","Montadas","Montanha",
				"Montevid�o","Moreno","Morma�o","Morrinhos","Morros","Moscou","Mossor�","Motuca","Mucuri","Munhoz","Muqui","Murici","Mutum","Maranh�o","M�rida",
				"Michigan","Michoac�n","Minnesota","Miranda","Mississippi","Missouri","Montana","Morelos","Macau","Mal�sia","Mali","Malta","Marrocos","M�xico",
				"Mo�ambique","M�naco","Mong�lia","Montenegro",
				"Nadiad","Nadim","Nagercoil","Nagold","Nainital","Nalgonda","Namibe","Nampa","Nanaimo","Nancy","Nandurbar","Nanital","Nantes",
				"Nanuque","N�poles","Naque","Naranjal","Nashua","Nassau","Natal","Natalio","Natchez","Nat�rcia","Natividade","Natuba","Naucalpan","Nauen","Navira�",
				"Navsari","Nazar�","Naz�ria","Naz�rio","Neiva","Nellore","Nelson","Neman","Nettetal","Neuburg","Neuville","Nhamund�","Nice","Nicolet","Nidda","Ninheira",
				"Niter�i","Nobres","Norden","Nordestina","Normal","Normandia","Normandin","Nottingham","Nouakchott","Novais","Novara","Novorizonte","Nucualofa","Nuporanga",
				"Nagaland","Nasarawa","Nayarit","Nebraska","Neuqu�n","Nevada","N�ger","Nova Iorque","Nova J�rsei","Novo M�xico","Nam�bia","Nauru","Nepal","Nicar�gua",
				"N�ger","Nig�ria","Niue","Noruega","Nova Caled�nia","Nova Zel�ndia",
				"Ober�","�bidos","Obligado","Ocala","Ocara","Odenthal","Odessa","Odivelas","Oeiras","Oelde","Offenburg","Ogden","Ojereli","Olaria","�leo","Ol�mpia",
				"Olinda","Oliveira","Olpe","Ondjiva","Oneonta","Ongole","Ont�rio","Opelousas","Orai","Orange","Orat�rios","Orem","Oriente","Orillia","Oriol","Orizona",
				"Orlando","Orle�es","Orob�","Oroc�","Orono","Or�s","Oruro","Osasco","Oslo","Os�rio","Osterode","Ottawa","Our�m","Ouricuri","Ourinhos","Ourizona","Ouro",
				"Ouroeste","Ouvidor","Ovar","Oxford","Oziori","Oaxaca","Obwald","Ogun","Ohio","Oklahoma","Ondo","Oregon","Orissa","Osun","Oyo","Om�",
				"Pacaembu","Pacaj�","Pacajus","Pacoti","Pacuj�","Paial","Painel","Paiva","Palestina","Palho�a","Palmas","Palmeiras","Palmelo","Palmital","Panam�","Pancas",
				"Panelas","Panorama","Papagaios","Para�so","Paramaribo","Paraty","Pardinho","Parecis","Pariconha","Paripueira","Paris","Parisi","Passagem","Passos","Patos",
				"Patroc�nio","Patu","Paudalho","Paulista","Pav�o","Peabiru","Pe�anha","Pedra","Pedreira","Peixe","Pelotas","Penaforte","Penha","Pentecoste","Pequi","Pequim",
				"Pequizeiro","Perdizes","Perd�es","Pereiras","Periquito","Perobal","P�rola","Pesqueira","Piau","Picos","Picu�","Piedade","Pi�n","Pilar","Pil�es","Pimenta",
				"Pinda�","Pinh�o","Pinheiro","Pintadas","Piquete","Piracema","Piranhas","Pirap�","Piraqu�","Piripiri","Pitanga","Pitangueiras","Placas","Planalto","Platina",
				"Po�","Po��o","Pocinhos","Po��es","Podgorica","Pombos","Pont�o","Port�o","Porteirinha","Posse","Pot�","Potim","Pracinha","Prainha","Prata","Pret�ria",
				"Primavera","Princesa","Progresso","Pureza","Putinga","Par�","Para�ba","Paran�","Pensilv�nia","Pernambuco","Piau�","Plateau","Portuguesa","Puebla","Punjabe",
				"Palau","Panam�","Paquist�o","Paraguai","Peru","Pol�nia","Porto Rico","Portugal",
				"Quadra","Quakenbr�ck","Quara�","Quarteira","Quat�","Quatigu�","Quatipuru","Quatis","Quebec","Quebrangulo","Quedlimburgo","Queimadas","Queimados","Queiroz",
				"Queluz","Queluzito","Quequ�n","Quer�ncia","Quer�taro","Querfurt","Quesnel","Quevedos","Qu�bor","Quickborn","Quiindy","Quijingue","Quillacollo","Quilombo",
				"Quincy","Quintana","Quipap�","Quirin�polis","Quissam�","Quitandinha","Quiterian�polis","Quito","Quixaba","Quixabeira","Quixad�","Quixel�","Quixeramobim",
				"Quixer�","Quyquyh�","Quer�taro de Arteaga","Quintana Roo","Qatar","Quirguist�o",
				"Rafard","Raleigh","Ramil�ndia","Rancharia","Raposa","Raposos","Realeza","Rebou�as","Recife","Recreio","Reden��o","Redentora","Reduto","Regenera��o",
				"Registro","Relvado","Remanso","Renascen�a","Resende","Reserva","Resplendor","Ressaquinha","Restinga","Revere","Riach�o","Riachinho","Riachuelo","Rialma",
				"Rialto","Ribeira","Ribeir�o","Rifaina","Riga","Rinc�o","Riozinho","Riqueza","Riverside","Rochedo","Rochester","Rockford","Rodeio","Rodeiro","Rodelas",
				"Rolador","Rolante","Roma","Romaria","Roncador","Rondinha","Rondon","Rosana","Ros�rio","Roseau","Roseira","Roteiro","Rubelita","Rubim","Rubin�ia","Russas",
				"Ruston","Rajast�o","Ren�nia-Palatinado","Rhode Island","Rio de Janeiro","Rio Grande do Norte","Rio Grande do Sul","R�o Negro","Rivers","Rond�nia","Roraima",
				"Rep�blica Tcheca","Rom�nia","Ruanda","R�ssia",
				"Sabino","Saboeiro","Sacramento","Salem","Sales","Salete","Salgadinho","Salgado","Salgueiro","Salinas","Salitre","Salta","Saltinho","Salto","Salvador",
				"Salvaterra","Samba�ba","Sampaio","Sana","Santaluz","Santana","Santar�m","Santiago","Santos","Sap�","Sapezal","Sapucaia","Sarasota","Satara","Satuba",
				"Saudades","Sa�de","Seara","Segredo","Selma","Sem-Peixe","Senador Pompeu","Serid�","Seringueiras","S�rio","Serra","Serrana","Serrania","Serranos",
				"Serraria","Serrinha","Serrita","Serro","Sertaneja","Sert�o","Sert�ozinho","Seul","Sevilha","Silv�nia","Silveiras","Silves","Sim�es","Sinop","Siracusa",
				"Siriri","Slidell","Sobrado","Sobral","Socorro","S�fia","Soledade","Solid�o","Sombrio","Sonora","Sorocaba","Sorriso","Soss�go","Sousa","Sucupira",
				"Sumidouro","Surat","Surrey","Surubim","Sussuapara","Suva","Suzano","Storrs","S�o Paulo","Sergipe","Sarre","Sax�nia","Sonora","Sinaloa","Sucre","Sikkim",
				"Sokoto","San Marino","Senegal","Serra Leoa","S�rvia","S�ria","Som�lia","Sud�o","Su�cia","Su��a","Suriname",
				"Tabuleiro","Tacaimb�","Tail�ndia","Taiobeiras","Tai�","Talism�","Tamandar�","Tamboril","Tandil","Tanquinho","Tapera","Tapira","Taquara","Taquaral",
				"Tarabai","Tarrafas","Tarragona","Tarum�","Tashkent","Tatu�","Taunton","Tavares","Tbilisi","Tef�","Tegucigalpa","Teixeira","Telha","Tenali","Ten�rio",
				"Terenos","Teresina","Terezinha","Terrace","Tesouro","Teut�nia","Thane","Tibau","Tiet�","Tigre","Tigrinhos","Tijucas","Timb�","Timmins","Timon","Tim�teo",
				"Timphu","Tiradentes","Tiros","Tocant�nia","Toledo","Tombos","Torixor�u","Torres","Torrinha","Toulon","Toulouse","Touros","Towson","Trail","Trair�o","Trairi",
				"Travesseiro","Tremedal","Trememb�","Trenton","Trindade","Trinidad","Triunfo","Trombas","Trujui","Tubar�o","Tucano","Tucum�","Tunas","Tunis","Tup�","Tupelo",
				"Turv�nia","Turvo","Tut�ia","Tocantins","Tur�ngia","Tlaxcala","Tabasco","Texas","Tennessee","Tripura","T�chira","Trujillo","Taraba","Tadjiquist�o","Tail�ndia",
				"Taiwan","Tanz�nia","Timor Leste","Togo","Tonga","Tun�sia","Turquia","Tuvalu",
				"Uarini","Uau�","Ub�","Ubajara","Ubat�","Ubatuba","Uberaba","Uberl�ndia","Ubirajara","Ubirat�","Uchoa","�dine","Uelzen","Ufa","Uiba�","U�ge","Uira�na","Ujjain",
				"Ulm","Umari","Umarizal","Umba�ba","Umbuzeiro","Umirim","Una","Uni�o","Uniflor","Uni�n","Unistalda","Unna","Unnao","Upanema","Upata","Ura�","Urandi","Ur�nia",
				"Urbana","Urdinarrain","Uren","Urjum","Uru","Urua�u","Uruana","Urubici","Uruc�nia","Urucar�","Urucuia","Uruoca","Urupema","Urussanga","Uruta�","Uslar","Utica",
				"Utinga","Uyuni","Uzlovaia",
				"Vacaria","Vaduz","Valdez","Valen�a","Valente","Valetta","Valinhos","Valladolid","Valpara�so","Vancouver","Vanini","Vapi","Varge�o","Vargem","Varginha","Varj�o",
				"Varjota","Varre-Sai","Vars�via","V�rzea","Varzedo","Vassouras","Vazante","Vellore","Venha-Ver","Ventania","Venturosa","Vera","Verdejante","Ver�","Vereda",
				"Veredinha","Ver�ssimo","Vernon","Vertentes","Vespasiano","Viadutos","Viam�o","Viana","Vic�ncia","Vicentina","Vi�osa","Victoria","Videira","Vieiras","Viena",
				"Vietiane","Vigia","Vilhena","Vilnius","Vinhedo","Viradouro","Virar","Virg�nia","Virgol�ndia","Virmond","Vit�ria","Vitorino","Viseu","Votorantim","Valais",
				"Vargas","Vaud","Veracruz","Vermont","Viena","Virg�nia","Virg�nia Ocidental","Vorarlberg","Vanuatu","Vaticano","Venezuela","Vietn�",
				"Zabel�","Zacarias","Zacatecas","Zacatepec","Zacazonapan","Zacualpan","Zagreb","Zapopan","Zapotiltic","Zapotlanejo","Zaragoza","Zaraisk","Zaraza","Z� Doca",
				"Zehdenick","Zeitz","Zelenodolsk","Zelenograd","Zelenogradsk","Zentla","Zerbst","Zihuatanejo","Zinacant�n","Zinacantepec","Zir�ndaro","Zirndorf","Zitlala",
				"Zittau","Zlatoiust","Zongolica","Zontecomatl�n","Zort�a","Zossen","Zucualpan","Zugo","Z�lpich","Zumpahuac�n","Zumpango","Zurique","Zvenigorod","Zweibr�cken",
				"Zwickau","Zacatecas","Zulia","Zamfara","Zurique","Zugo","Z�mbia","Zimb�bue",
		};

		return palavras;}
	
	private static String[] getObjetos(){
		String respostasObjetos[] = {
				"�baco","Abafador","Abajur","Abra�adeira","Abre-latas","Acorde�o","A�ucareiro","Adaga","Adaptador","Aerof�lio",
				"Afox�", "Agenda", "Agog�", "Agulha","Agulheiro","Alarme","Ala�de","�lbum","Aldrava","Alfinete","Alforje",
				"Algema","Algod�o","Alicate","Alidade","Aljava","Almofada","Almofariz","Alto falante","Amortecedor","Ampulheta",
				"Amuleto","�ncora","Andador","Andaime","Anilha","Antena","Antolho","Anzol","Apagador","Aparador","Apito",
				"Apontador de l�pis","Aqu�rio","Aquecedor","Arco","Armadilha","Armadura","Arm�rio","Aro","Arp�o","Arruela",
				"Artrosc�pio","Asa delta","Aspirador","Assadeira","Astr�grafo","Astrol�bio","Autorama","Azulejo",
				"Baf�metro","Bagageiro","Baioneta","Baixo","Balaclava","Balaio","Balalaika","Balan�a","Bal�o","Bala�stre","Baleiro",
				"Balsa","Bambol�","Banco","Bandana","Bandeira","Bandola","Bandolim","Bandoneon","Banjo","Banqueta","Baqueta",
				"Barbante","Barraca","Barril","Basculante","Base","Bast�o","Bata","Bat�","Batedeira","Batente","Bateria","Batina",
				"Batom","Batuta","Ba�","Bazuca","Beca","Beliche","Bengala","Ber�o","Berimbau","Betoneira","B�blia","Bicama",
				"Bid�","Bigorna","Bin�culo","Biruta","Bisturi","B�ia","Bola","Bomba de �leo","Bombarda","Boneca","Bong�","Bot�o",
				"Botina","Brinco","Broca","Bucha","Bule","Bumerangue","Buzina",
				"Cabide","Ca�arola","Cachimbo","Cadeado","Cadeira","Caderno","Cafeteira","Caix�o","Cajado","Caldeir�o","Calibrador",
				"C�lice","Cama","Candeeiro","Candelabro","Caneca","Caneleira","Caneta","Canga","Canivete","Cantil","Capa","Capacete",
				"C�psula","Carimbo","Carregador","Carretel","Cart�o","Carteira","Castanholas","Casti�al","Catavento","Catraca","Cavalete",
				"Cavaquinho","Cd","Celular","Cesta","Chaleira","Chap�u","Charuto","Chave","Chicote","Chinelo","Chip","Chocalho","Chupeta",
				"Chuteira","Chuveiro","Clip","Coador","Cofre","Colch�o","Coleira","Colher","C�moda","Compasso","Concha","Cone","Contrabaixo",
				"Corneta","Crach�","Crucifixo","Cutelo",
				"Dado","Dardo","Dedal","Delineador","Depilador","Dep�sito de Ommaya","Desentupidor","Desfibrilador","Desinfetante","Desodorante",
				"Despertador","Desumidificador","Detector","Detergente","Diabolo","Diamante","Di�rio","Didjeridu","Disco","Disquete","Div�","Dobro",
				"Domin�","Draga","Dreidel","Drums","Duduk","Dul�aina","Dulciana","Dulcimer","Duto","Dvd","DVR",
				"Echarpe","Edredom","Eixo","El�stico","Elevador","Elmo","Embreagem","Enceradeira","Engate","Engrenagem","Envelope","Enxada","Escada",
				"Escapamento","Escavadeira","Escopeta","Escorredor","Escorregador","Escova","Escudo","Escumadeira","Esfera","Esfigmoman�metro","Esfreg�o",
				"Esmalte","Espa�ador","Espada","Espadrilha","Espanador","Esparadrapo","Espartilho","Esp�tula","Espelho","Espeto","Espineta","Espingarda",
				"Espiral","Espir�grafo","Esponja","Espremedor","Esquadro","Estabilizador","Estaca","Estandarte","Estator","Est�tua","Esteira","Estetosc�pio",
				"Estilete","Estilingue","Estojo","Estribo","Etiqueta","Euf�nico","Euf�nio","Exaustor","Expansor","Extintor",
				"Faca","Fac�o","Fagote","Fantasia","Fantoche","Faqueiro","Farda","Farinheiro","Farol","Farolete","Fax","Feliscorne","Ferradura","Ferramenta",
				"Ferro de passar","Ferrolho","Ferrorama","Fibra","Fich�rio","Figurinha","Filmadora","Filtro","Fio","Fita","Fivela","Fixador","Flanela",
				"Fl�mula","Flauta","Flautim","Flecha","Fliscorne","Flugelhorn","Focinheira","Fog�o","Foguete","Foice","F�rceps","Forma","Form�o","Forno",
				"Frasco","Frasqueira","Freezer","Freio","Frigideira","Frigobar","Fritadeira","Fronha","Fruteira","Fulannu","Funda","Funil","Furadeira",
				"Fus�vel","Fuzil",
				"Gabinete","Gaiola","Gaita","Galheteiro","Galocha","Gancho","Gangorra","Ganz�","Garfo","Gargantilha","Garrafa","Gashapon","Gatorra","Gaveta",
				"Gaxeta","Geladeira","Gel","Geleca","Geomag","Gesso","Gibi","Giz","Glockenspiel","Gloss","Gogos","Goma","Gorro","Gramofone","Grampeador",
				"Grampo","Granada","Gravata","Graxeta","Grelha","Grinalda","Grua","Guarda-barro","Guarda-chuva","Guarda-roupa","Guarda-sol","Guardanapo","Guardapolvo",
				"Guia de cabo","Guia de garfo","Guia de v�lvula","Guia grampo","Guid�o","Guidom","Guilhotina","Guirlanda","Guitarra",
				"Hal�metro","Haltere","Harm�nio","Harmonizador","Harmon�grafo","Harpa","H�rpaga","Haste","Hel�polis","H�lice","Helic�ptero","Hel�cula","Heli�metro",
				"Heliosc�pio","Heli�stato","Hemat�metro","Hemocit�metro","Hemodinam�metro","Hidrante","Hidratante","Hidroavi�o","Hidr�metro",
				"Higr�metro","Hip�metro","Hod�metro","Hojok","Holofote","Home theater","Horquilla","H�stia",
				"Iate","Icti�metro","Iga�aba","Igarit�","Ignitor","Ilho de borracha","�m�","Impressora","Inalador","Incenso","Ingresso","Injetor","Interfone",
				"Interruptor","Ioi�","Isolador","Isqueiro",
				"Jaleco","Janela","Jangada","Jaqueta","Jardineira","Jarra","Jarro","Jato","Jaula","Jo�o bobo","Joelheira","Joelho hidr�ulico",
				"Jogo da mem�ria","Jogo de an�is","Jogo de damas","Jogo de sapata","J�ia","Jornal","Joystick","Jumelo","Jun��o de mangueira",
				"Jun��o do carburador","Junta de veda��o","Junta do cabe�ote",
				"La�o","Lacre","L� de a�o","Lajota","L�mina","L�mpada","Lamparina","Lampi�o","Lan�a","Lan�a-granada","Lancetador","Lanceta","Lancheira",
				"Lantejoula","Lanterna","L�pis","Lapiseira","Laqu�","Laringoscopio","Lata","Lava-arroz","Lava-lou�as","Leiteira","Leitor de Dvd",
				"Leme","Len�o","Len�ol","Lente","Leque","L�ngua de sogra","Liquidificador","Litotriptor","Livro","Lixa de unha","Lixadeira","Lixeira",
				"Lona","Longarina","Lou�a","Lousa","Lumin�ria","Luneta","Lustre","Luva","Luva de boxe","Luva pvc",
				"Maca","Macaco hidr�ulico","Ma�aneta","Ma�arico","Machado","Mai�","Mala","Maleiro","Malhete","Mamadeira","Mandolina","Manequim",
				"Mangueira","Manivela","Manta","Maquete","M�quina de costura","M�quina eletrost�tica","M�quina fotogr�fica","Marac�","Marca-passo",
				"Marcador de p�gina","Marimba","Marionete","Marreta","Martelo","M�scara de mergulho","M�scara de oxig�nio","Mastro",
				"Matraca","Medalha","Megafone","Meia","Meia cal�a","Melofone","Mesa","Metralhadora","Mi�anga","Micro-ondas","Microfone",
				"Microsc�pio","Mime�grafo","Minissaia","M�ssil","Misturador","Mochila","Modem","Moeda","Mola","Molheira","Molinete","Monitor",
				"Mon�culo","Moodswinger","Mosquiteiro","Motor","Mouse","Multiprocessador","Munhequeira","Mural",
				"Nadadeira","Narguil�","Navalha","Nave espacial","Naveta","Navio","Nebulizador","NeoCube","Netbook","Neutralizador de odores",
				"Ney","Niple","N�nio","Notebook","Novelo",
				"Obo�","Ocarina","Octante","�culos","Od�metro","Odontosc�pio","Odre","Oficleide","Oftalmosc�pio","Ofur�","Olho m�gico",
				"Ombreira","Orelh�o","�rg�o","Oste�tomo","Otosc�pio","Oxigenador","Ox�metro",
				"P�","Palete","Palet�","Palheta","Paliteiro","Palmilha","Pandeiro","Panela","Pano","Pantufa","Papel","Papete","Papiro","Para-raios",
				"Parabrisa","Parafina","Parafuso","Paraquedas","Pasta","Patinete","Pedal","Pendrive","P�ndulo","Peneira","Pente","Penteadeira",
				"Perfume","Pergaminho","Perisc�pio","Persiana","Peruca","Peteca","Pia","Piano","Picareta","Piercing","Pil�o","Pin�a","Pincel",
				"Pingente","Pino","Pipa","Pipeta","Pipoqueira","Pires","Pistola","Placa","Pneu","Pochete","Podadeira","Pod�o","Poltrona","Poncheira",
				"Ponteiro","Porta","Pote","Prancha","Prateleira","Prato","Pregador","Presilha","Proj�til","Pulseira","Pulverizador","Punhal","Puxador",
				"Quadrante de Davis","Quadriciclo","Quadriton","Quadro","Quadro de bicicleta","Quadro negro","Quebra-cabe�a","Quebra-nozes","Queijeira",
				"Quena","Quepe","Quimono","Quinticlave",
				"Rebab","Rabeca","Rabeta","Rabicho","Rack","Radar","R�dio","R�dio comunicador","Raio de bicicleta","Ralador","Ralo","Ralo seco","Ramalhete",
				"Raquete","Rasteirinha","Rastelo","Ratoeira","Rebite","Rebolo","Reco-reco","Rede","R�dea","Refletor","R�gua","Rel�","Relic�rio","Rel�gio",
				"Remo","Repelente","Repinique","Requinta","Resta-um","Retentor","Retificador","Retrato","Retroprojetor","Retrovisor","Revista","Revisteiro",
				"Rev�lver","Rifle","R�mel","Rinosc�pio","Roda","Rodap�","Rodo","Roladeira","Rolamento","Rolha","Rolo de massa","Rolo de pintura","Roomba",
				"Roteador","Rotor",
				"Sab�o barra","Sabonete","Saboneteira","Sabre","Sabre motosserra","Saca-rolhas","Sacabuxa","Saco","Sacola","Saia","Saladeira","Saleiro",
				"Salt�rio de Arco","Samba can��o","Samovar","Sampler","Sand�lia","Sanduicheira","Sanfona","Sapateira","Sapatilha","Sapato","Sarrusofone",
				"Saxofone","Saxotrompa","Scanner","Secador","Secadora","Selim","Sem�foro","Seringa","Serpentina","Serra","Serrote","Sextante","Short",
				"Sil�nciador","Sinalizador","Sino","Sinos tubulares","Sintetizador","Sirene","Skate","Smoking","Soco ingl�s","Sof�","Sombrero","Sombrinha",
				"Sonda hidrof�lica","Sonda nasog�strica","Sorveteira","Spray","Su�ter","Sunga","Suona","Suporte para TV","Suspens�rio","Suti�",
				"T�bua","Tabuleiro","Ta�a","Talher","Tamanco","Tamagotchi","Tambor","Tamborete","Tamborim","Tampa","Tanque","Tapete","Tarracha","Tatame",
				"Tear","Teasmade","Tecido","Teclado","Tela","Telefone","Telesc�pio","Televis�o","Telha","T�nis","Term�metro","Termostato","Terno","Terrina",
				"Tesoura","Tiara","Tigela","Tijolo","Toalha","Tobog�","Toga","Toldo","Tonel","Torneira","Tornozeleira","Torpedo","Torquetum","Torradeira",
				"Touca","Trampolim","Transferidor","Trave","Travesseiro","Triciclo","Tridente","Triquetrum","Triturador","Trof�u","Trombone","Trompa","Trompete",
				"Trono","Trotinete","Tuba","Tubo pvc","T�nica","Turbante","Turbina",
				"Ud�grafo","Ukulele","Ultrabook","Ultraleve","Umidificador","Unha posti�a","Uniforme","Urdideira","Ureterosc�pio","Urinol","Urna","Urso de pel�cia",
				"Vajra","V�lvula de escape","V�lvula termi�nica","V�lvula ventosa","Vaporizador","Vara de pesca","Varal","Vareta de freio","Vareta de solda",
				"Vaso","Vaso sanit�rio","Vassoura","Vedador anaer�bico","Vela de cera","Vela de igni��o","Veleiro","Veloc�metro","Ventilador","Verruma",
				"Vestido","V�u","V�u do c�lice","Vibrador","Vibrafone","V�deo cassete","V�deo game","Vidro de rel�gio","Viola","Viol�o","Violbass ac�stico","Violino",
				"Violoncelo","Virabrequim","Viscos�metro","Viseira","Vitrola","Volante","Volt�metro","Vuvuzela",
				"Zabumba","Zabuton","Zafu","Zampro�a","Zarabatana","Z�per","Zootropo"};
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
						System.out.println(respostas[0]+": v�lida.");
					else
						System.out.println(respostas[0]+": inv�lida.");
					
					if(respostas[1].charAt(0) == letra && Arrays.asList(getLugares()).contains(respostas[1]))
						System.out.println(respostas[1]+": v�lida.");
					else
						System.out.println(respostas[1]+": inv�lida.");
					
					if(respostas[2].charAt(0) == letra && Arrays.asList(getObjetos()).contains(respostas[2]))
						System.out.println(respostas[2]+": v�lida.");
					else
						System.out.println(respostas[2]+": inv�lida.");
						
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
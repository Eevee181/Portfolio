/* TIEP5.1 Lausekielinen ohjelmointi II
 * Harjoitustyö: Binääristä ASCII-grafiikkaa
 * Eveliina Toivanen (toivanen.eveliinarai@gmail.com)
 */

import java.util.Scanner;
import java.io.*;

/* Ohjelma lukee tiedoston, johon on ladattu ASCII-graafisia tietoja ja käsittelee saamaansa
 * informaatiota käyttäjän antamien komentojen mukaisesti printaten kuvaa, muokaten sen ulkonäköä
 * tai ladaten sen uudestaan. 
 */
 
public class BimEdit{
    
    // Muodostetaan luokkavakiot tehtävän komennoista.
    public static final String PRINT = "print"; 
    public static final String INFO = "info";
    public static final String INVERT = "invert";
    public static final String DILATE = "dilate";
    public static final String ERODE = "erode";
    public static final String LOAD = "load";
    public static final String QUIT = "quit";
    
    /* Metodi lukee käyttäjän syöttämän tiedoston ja jos ongelmia ei tule, muuntaa
     * sen informaatiotauluksi, jonka palauttaa takaisin metodin kutsujalle.
     * commandRow: Käyttäjän antama tiedosto.
     */
    public static String[] readFile(String[] commandRow){
        // Esitellään lukija try-lohkon ulkopuolella, jotta sitä voidaan käyttää catch-lohkossa.
        Scanner fileScanner = null;
        
        try{
            // Määritetään sallittu komento ja se, missä tiedostonnimi sijaitsee.
            String fileName = commandRow[0];
            String acceptedCom = "echo";
            
            // Tarkastetaan onko komentorivi pidempi kuin yksi.
            if(commandRow.length > 1){
                String secondCom = commandRow[1];
                
                // Jos tiedoston mukana annettu komento ei ole oikea, komentorivi hylätään.
                if (secondCom.equals(acceptedCom) == false || commandRow.length > 2){
                    throw new IllegalArgumentException();
                }
            }
            
            File file = new File(fileName);
            fileScanner = new Scanner(file);
            
            // Luetaan tiedoston ensimmäinen rivi, josta saadaan tiedostossa olevan kuvan koko.
            int imageSize = Integer.parseInt(fileScanner.nextLine());
            
            // Luodaan string-taulu, johon koko tiedosto tallennetaan. Sisällytetään kokoon myös
            // neljä ensimmäistä riviä ennen kuvaa ja asetetaan ensimmäinen tiedoston rivi ensimmäiseen
            // taulun arvoon.
            String[] fileArray = new String[imageSize + 4];
            fileArray[0] = Integer.toString(imageSize);
            
            // Luodaan apumuuttujalaskin, joka lähtee liikkeelle seuraavasta vapaasta sijainnista.
            int calculator = 1;
            
            // Luodaan apumuuttujat kuvan oikeellisuuden tarkistamiseksi.
            int colSize = 0;
            String backMark = "";
            String frontMark = "";
            
            // Käydään tiedosto läpi niin pitkään kuin vain tiedostossa riittää rivejä
            while (fileScanner.hasNextLine()) {

                // Luetaan seuraava rivi, jota lähdetään tarkastelemaan.
                String row = fileScanner.nextLine();
                
                // Annetaan luoduille apumuuttujille arvot tiedostoa läpikäydessä.
                if(calculator == 1){
                    colSize = Integer.parseInt(row);
                }
                if(calculator == 2){
                    backMark = row;
                }
                if(calculator == 3){
                    frontMark = row;
                }
                
                // Kuvan kohdalle päästessä suoritetaan kuvan oikeellisuuden tarkistukset.                
                if (calculator > 3){
                    
                    // Jos jonkin rivin pituus eroaa annetusta, kuva on virheellinen.
                    if (row.length() != colSize){
                        System.out.println("Invalid image file!");
                        return null;
                    }
                      
                    // Tarkastetaan, että merkkejä on vain annettuja kahta erilaista, 
                    // käymällä rivi läpi for-luupilla.  
                    String[] lines = row.split("");
                    for (int i = 0; i < row.length(); i++) {
                        if (lines[i].charAt(0) != backMark.charAt(0) && lines[i].charAt(0) != frontMark.charAt(0)){
                        
                            System.out.println("Invalid image file!");
                            return null;
                        }
                    }  
                }
                
                // Tarkastetaan, ettei rivien määrä ole liian korkea. Muussa tapauksessa tulostetaan virheilmoitus.
                // Lisätään kuvan kokoon 3, sillä laskin aloittaa laskunsa tiedoston toiselta riviltä.
                if (calculator > (imageSize + 3)){
                    System.out.println("Invalid image file!");
                    return null;
                }
                
                //Jos virheitä ei tule, lisätään rivi tiedostotauluun.
                fileArray[calculator] = row;
                
                // Suurennetaan laskimen arvoa yhdellä.
                calculator ++; 
                
            }
            
            // Tarkastetaan, jäikö rivien määrä annettua määrää pienemmäksi. Jos jäi, tulostetaan virheilmoitus.
            if(calculator < (imageSize + 3)){
                System.out.println("Invalid image file!");
                    return null;
            }
            
            // Suljetaan lukija 
            fileScanner.close();
            
            // Palautetaan tiedoston tiedot sisältävä taulu metodin kutsujalle.
            return fileArray;
        }
        
        // Virheen osuessa kohdalle, tulostetaan virheilmoitus ja palautetaan tyhjäarvo kutsujalle.
        catch (FileNotFoundException e) {
            // Suljetaan lukija mikäli sellainen on ehditty luomaan.
            if (fileScanner != null) {
                fileScanner.close();
            }
            
            System.out.println("Invalid image file!");
            
            return null;
        }
        
        // Virheen osuessa kohdalle, tulostetaan virheilmoitus ja palautetaan tyhjäarvo kutsujalle.
        catch (ArrayIndexOutOfBoundsException e) {
            // Suljetaan lukija mikäli sellainen on ehditty luomaan.
            if (fileScanner != null) {
                fileScanner.close();
            }
            
            System.out.println(("Invalid command-line argument!"));
            
            return null;
        }
        
        // Virheen osuessa kohdalle, tulostetaan virheilmoitus ja palautetaan tyhjäarvo kutsujalle.
        catch (IllegalArgumentException e){
            // Suljetaan lukija mikäli sellainen on ehditty luomaan.
            if (fileScanner != null) {
                fileScanner.close();
            }
            
            System.out.println("Invalid command-line argument!");
            
            return null;
        }
        

    }
    
    
    /* Metodi muokkaa informaatiotaulussa olevan kuvan kaksidimensionaaliseksi char-tyypin
     * tauluksi ja palauttaa sen takaisin metodin kutsujalle.
     * allInformation: Taulu, johon on tallennettu kaikki käyttäjän tiedostossa ollut tieto.
     */
    public static char[][] convertArray2D(String[] allInformation){
        
        // Otetaan informaatiotaulusta tiedot kuvan koosta ja luodaan niistä apumuuttujat.
        int size1 = Integer.parseInt(allInformation[0]);
        int size2 = Integer.parseInt(allInformation[1]);
        
        // Muodostetaan taulukko, johon kuva tallenetaan.
        char[][] onlyPic = new char[size1][size2];
        
        // Käydään uusi taulu sijainti kerrallaan lävitse ja kopioidaan informaatiotaulun
        // kuva sinne.
        for(int i=4; i < size1 + 4; i++){
            for(int j=0; j < size2; j++){
                onlyPic[i-4][j] = allInformation[i].charAt(j);
            }
        }
        
        // Palautetaan taulu metodin kutsujalle.
        return onlyPic;
        
    }
    
    /* Luodaan alkuperäisistä informaatioista varmuuskopio.
     * info: Taulu, johon on tallennettu käyttäjän antaman tiedoston tiedot.
     */
    public static String[] informationSave(String[] info){
        // Luodaan aputaulu, johon varmuuskopio tallennetaan.
        String[] savedInfo = new String[info.length];
        
        for(int i = 0; i < info.length; i++){
            savedInfo[i] = info[i];
        }
        
        // Palautetaan metodin kutsujalle varmuuskopio.
        return savedInfo;
    
    }
    
    /* Metodi tarkastaa käyttäjän antaman komennon ja muuttaa sen tiedot komentotauluksi.
     * command: Käyttäjän pääohjelmassa syöttämä komento.
     */
    public static String[] checkCommand(String command){
        
        // Tarkastetaan onko komento olemassa. Jos on, muodostetaan siitä komentotaulu.
        if (command != null){
            String[] commandArr = command.split(" ");
            
            // Palautetaan komentotaulu metodin kutsujalle.
            return commandArr;
        }
        
        else{
            // Jos komentoa ei ole olemassa, palautetaan tyhjäarvo.
            return null;
        }
    }
    
    /* Metodi tulostaa parametrinaan saamansa kaksidimensionaalisen taulun, kunhan
     * kuva ei ole tyhjä.
     * onlyPic: Kuva, joka halutaan tulostaa.
     */
    public static void printer(char[][] onlyPic){
        
        // Jos parametrina saatu taulu ei ole tyhjä, voidaan se käydä läpi yksikkökerrallaan
        // ja tulostaa.
        if(onlyPic != null){
            for(int i = 0; i < onlyPic.length; i++){
                for (int j = 0; j < onlyPic[0].length; j++){
                    System.out.print(onlyPic[i][j]);
                }
                System.out.println();
            }
        }        
    }
    
    /* Metodi tarkastelee taulun sisältämää informaatiota, kuten kokoa ja merkkien määriä
     * ja printtaa tiedot käyttäjän nähtäville.
     * information: Taulu, jossa on kaikki info käyttäjän antamasta tiedostosta.
     * pic: Kaksidimensionaalinen kuva, joka on muodostettu käyttäjän tiedostosta.
     */
    public static void giveInfo(String[] information, char[][] pic){
        String size1 = information[0];
        String size2 = information[1];
        
        // Vaihdetaan merkkien yksikköä, jotta niitä voidaan myöhemmin käsitellä
        // ja määritetään etu- ja takamerkit.
        char[] marks = changeMarksToChar(information);
        char backMark = marks[0];
        char frontMark = marks[1];
        
        // Muodostetaan apumuuttujalaskurit, jotta merkkien lkm voidaan laskea.
        int calcBack = 0;
        int calcFront = 0;

        // Lasketaan etu- ja takamerkkien lukumäärä käymällä jokainen taulun arvo läpi.
        for(int i = 0; i < pic.length; i++){
            for(int j = 0; j < pic[i].length; j++){
                if (pic[i][j] == backMark){
                    calcBack++;
                }
                else if(pic[i][j] == frontMark){
                    calcFront++;
                }
            }
        }
        
        // Tulostetaan kuvan informaatio nähtäville.
        System.out.println(size1 + " x " + size2);
        System.out.println(backMark + " " + calcBack);
        System.out.println(frontMark + " " + calcFront);
    }
    
    /* Metodi muuttaa parametrinaan saamansa ASCII-kuvan etumerkkien ja takamerkkien paikkoja.
     * informaation: Käyttäjän tiedoston informaatiosta tehty taulu.
     * pic: Käyttäjän tiedoston perusteella tehty kaksidimensionaalinen ASCII-kuva.
     */
    public static char[][] inverter(String[] information, char[][] pic){
        // Vaihdetaan merkkien yksikköä, jotta niitä voidaan myöhemmin käsitellä
        // ja määritetään merkit.
        char[] marks = changeMarksToChar(information);
        char firstMark = marks[0];
        char secondMark = marks[1];
        
        // Käydään taulu läpi arvo kerrallaan ja vaihdetaan merkkien paikkoja päittäin.
        for(int i = 0; i < pic.length; i++){
            for(int j = 0; j < pic[i].length; j++){
                if (pic[i][j] == firstMark){
                    pic[i][j] = secondMark;   
                }
                else if(pic[i][j] == secondMark){
                    pic[i][j] = firstMark;
                }
            }
        }
        
        // Muutetaan uudet etu- ja takamerkit informaatiotauluun.
        String backMark = String.valueOf(secondMark);
        String frontMark = String.valueOf(firstMark);
        information[2] = backMark;
        information[3] = frontMark;
        
        // Palautetaan muokattu kuva.
        return pic;
    }
    
    /* Metodi muuttaa kuvan kokoa sen mukaan, saako se etu- vai takamerkin parametrinaan. 
     * Metodi antaa paluuarvonaan muokatun kuvan.
     * pic: Kuva, jonka kokoa halutaan muokata.
     * commandArr: Taulu, jossa on käyttäjän antama komento.
     * mark: merkki, joka halutaan dilatoida tai vaihtoehtoisesti erosioida.
     */
    public static char[][] dilater(char[][] pic, String[] commandArr, char mark){ 
        // Luodaan apumuuttuja taulukko ja kopioidaan kuva siihen.
        char[][] differentPic = new char[pic.length][pic[1].length];
        for(int i = 0; i < pic.length; i ++){
            for(int j = 0; j < pic[i].length; j ++){
                differentPic[i][j] = pic[i][j];
            } 
        }
        
        // Luodaan apumuuttuja dilaation suurudelle ja kuvan rivi- ja sarakekooille.
        int dilateNumber = Integer.parseInt(commandArr[1]);
        int rowAmount = pic.length;
        int columnAmount = pic[0].length;
        
        // Suoritetaan dilaatio vain, kun dilaatio on suurempi kuin kaksi ja numero on pariton.
        if (dilateNumber >= 3 && dilateNumber % 2 != 0){
            
            // Lasketaan reunojen koko.
            int sideSize = (dilateNumber-1)/2;
            
            // Käydään kuva läpi rivi ja sarake kerrallaan, jotta voidaan muodostaa pohja ikkunalle, jossa haluttava
            // muutos tapahtuu
            for(int rowCalc = 0; rowCalc <= rowAmount - dilateNumber; rowCalc++){
                for(int columnCalc = 0; columnCalc <= columnAmount - dilateNumber; columnCalc++){
                    
                    // Käydään läpi ikkunan muodostava alue, jossa muutos tarvittaessa tehdään.
                    for(int winRowCalc = rowCalc; winRowCalc < rowCalc + dilateNumber; winRowCalc++){
                        for(int winColumnCalc = columnCalc; 
                        winColumnCalc < columnCalc + dilateNumber; winColumnCalc++){
                            
                            // Jos haluttu merkki löytyy ikkunasta, muutetaan apumuuttujakuvaan sen ikkunan 
                            // keskimerkki.
                            if(pic[winRowCalc][winColumnCalc] == mark){
                                differentPic[rowCalc + sideSize][columnCalc + sideSize] = mark;
                            }
                        }
                    }
                }
            }
        }
        
        // Palautetaan muokattu kuva kutsujalle.
        return differentPic;
    }
    
    /* Metodi muokkaa informaatiotaulussa string-muodossa olevat etu- ja takamerkit
     * char-muotoisiksi ja palauttaa kutsujalle näistä merkeistä muodostuvan char-taulukon.
     * information: taulu, johon on koottu käyttäjän antaman tiedoston tiedot.
     */
    public static char[] changeMarksToChar(String[] information){
        // Luodaan apumuuttujataulu, johon merkit voi tallentaa char-muodossa.
        char[] marks = new char[2];
        
        // Muokataan merkit char-tyyppisiksi arvoiksi.
        String firstMark = information[2];
        String secondMark = information[3];
        char backMark = firstMark.charAt(0);
        char frontMark = secondMark.charAt(0);
        
        // Lisätään merkit apumuuttujatauluun.
        marks[0] = backMark;
        marks[1] = frontMark;
        
        // Palautetaan taulu metodin kutsujalle.
        return marks;
    }
    
    /* Pääohjelma tulostaa tervehdystekstin, ja lähettää metodikutsun tiedostonlukijalle. Riippuen palautteesta se
     * joko pysäyttää ohjelman kulun tai siirtyy käsittelemään ohjelman toimintoja luupissa.
     */
    public static void main(String[] args){
        System.out.println("-----------------------");
        System.out.println("| Binary image editor |");
        System.out.println("-----------------------");
        
        
        String[] fileInfo = readFile(args);
        
        // Jos ohjelma saa tiedostonluku-metodilta paluuarvonaan tyhjäarvon, tulostetaan hyvästit.
        if (fileInfo == null){
            System.out.println("Bye, see you soon.");
        }
            
        else{
            // Luodaan kaksiulotteinen kuva hyödyntämällä käyttäjän antamia tietoja ja tallennetaan alkuperäiset
            // perustiedot uudelleenlataamisen varalta.
            char[][] onlyPic = convertArray2D(fileInfo);
            String[] originalInfo = informationSave(fileInfo);
            
            // Alustetaan lukija ja luodaan apumuuttuja, jolla ylläpidetään komentojen luuppia.
            boolean goOn = true;
            Scanner scanner = new Scanner(System.in);
            
            while(goOn == true){
                //Pyydetään käyttäjältä komento ja tarkistetaan se omassa metodissaan.
                System.out.println("print/info/invert/dilate/erode/load/quit?");
                String command = scanner.nextLine();
                String[] commandArr = checkCommand(command);
                
                // Kaiken ollessa ok, etsitään oikea komento ja suoritetaan sen vaatimat asiat.
                if(commandArr[0].equals(PRINT) && commandArr.length < 2){
                    printer(onlyPic);
                }
                else if(commandArr[0].equals(INFO) && commandArr.length < 2){
                    giveInfo(fileInfo, onlyPic);
                }
                else if(commandArr[0].equals(INVERT) && commandArr.length < 2){
                    char[][] invertedPic = inverter(fileInfo, onlyPic);
                    invertedPic = onlyPic;
                }
        
                else if(commandArr[0].equals(DILATE)){
                    // Jos komentotaulun sisältö on sopiva, voidaan komentoa jatkaa. Muussa tapauksessa se hylätään.
                    if(commandArr.length > 1 && commandArr.length < 3){
                        int dilateNumber = Integer.parseInt(commandArr[1]);
                        
                        // Jos dilatoitava numero on sallituissa rajoissa, voidaan dilatointi suorittaa. Muussa
                        // tapauksessa komento hylätään.
                        if(dilateNumber >= 3 && dilateNumber % 2 != 0 && dilateNumber <= onlyPic.length){
                            char[] marks = changeMarksToChar(fileInfo);
                            char frontMark = marks[1];
                            onlyPic = dilater(onlyPic, commandArr, frontMark);
                        }
                        else{
                            System.out.println("Invalid command!");
                        }                            
                    }
                    else{
                        System.out.println("Invalid command!");
                    }
                }
        
                else if(commandArr[0].equals(ERODE)){
                    // Jos komentotaulun sisältö on sopiva, voidaan komentoa jatkaa. Muussa tapauksessa se hylätään.
                    if(commandArr.length > 1 && commandArr.length < 3){
                        int erodeNumber = Integer.parseInt(commandArr[1]);
                        
                        // Jos dilatoitava numero on sallituissa rajoissa, voidaan dilatointi suorittaa. Muussa
                        // tapauksessa komento hylätään.
                        if(erodeNumber >= 3 && erodeNumber % 2 != 0 && erodeNumber <= onlyPic.length){
                            char[] marks = changeMarksToChar(fileInfo);
                            char backMark = marks[0];
                            onlyPic = dilater(onlyPic, commandArr, backMark);
                        }
                        
                        else{
                            System.out.println("Invalid command!");
                        }
                    }
                    else{
                        System.out.println("Invalid command!");
                    }
                }
        
                else if(commandArr[0].equals(LOAD) && commandArr.length < 2){
                    onlyPic = convertArray2D(fileInfo);
                    fileInfo = originalInfo;
                }
                
                // Lopetus-kutsussa luuppia ei enää jatketa, joten booleon muuttuu epätodeksi.
                else if(commandArr[0].equals(QUIT) && commandArr.length < 2){
                    goOn = false;
                    System.out.println("Bye, see you soon.");
                }
                
                // Komennon ollessa väärä, se hylätään.
                else{
                    System.out.println("Invalid command!");
                }
            }
        }
 
    }
}
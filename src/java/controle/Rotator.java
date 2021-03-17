/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

/**
 *
 * @author diogo11
 */
public class Rotator {
    private String imagens[] = {"imagens/fla-11-601x338.jpg", "imagens/camp2020.jpg", "imagens/flamengo-24112019175809334.jpeg"};
    private int selectedIndex = 0;
    private String links[] = {
    "https://static-wp-tor15-prd.torcedores.com/wp-content/uploads/2019/11/fla-11-601x338.jpg",
    "https://veja.abril.com.br/wp-content/uploads/2021/02/FLAMENGO-1-Campea%CC%83o-Brasileiro-1.jpg?quality=70&strip=info&resize=680,453",
    "https://img.r7.com/images/flamengo-24112019175809334?dimensions=660x360",};
    
    public String getImage(){
        return imagens[selectedIndex];
    }
    
    public String getLink(){
        return links[selectedIndex];
    }
    
    public void nextAd() {
        selectedIndex = (selectedIndex + 1) % imagens.length;
    }
}

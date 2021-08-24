/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author AlexandreSCorreia
 */
public class VPN extends EntidadeBase {

    private String Nome;
    private String Server;
    private String L2tpPsk;

    public VPN(String Nome, String Server, String Password) {
        this.Nome = Nome.trim() == "" || Nome.trim().isEmpty() == true ? "VPN 1" : Nome;
        this.Server = Server.trim() == "" || Server.trim().isEmpty() == true ? "Endereço da vpn" : Server;
        this.L2tpPsk = Password.trim() == "" || Password.trim().isEmpty() == true ? "Password" : Password;

    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getServer() {
        return Server;
    }

    public void setServer(String Server) {
        this.Server = Server;
    }

    public String getL2tpPsk() {
        return L2tpPsk;
    }

    public void setL2tpPsk(String L2tpPsk) {
        this.L2tpPsk = L2tpPsk;
    }

    @Override
    public String toString() {
        return "Nome:" + Nome + ", Servidor:" + Server;
    }

}

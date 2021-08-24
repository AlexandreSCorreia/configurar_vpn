/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import interfaces.IRepositorio;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AlexandreSCorreia
 */
public class VPNRepositorio implements IRepositorio<VPN> {

//https://www.ti-enxame.com/pt/java/execute-comandos-cmd-por-meio-do-java/1072673727/
    @Override
    public List<VPN> FindAll() {
        List<VPN> listaVPN = new ArrayList<>();
        try {
            ProcessBuilder builder = new ProcessBuilder(
                    "powershell.exe", "Get-VpnConnection");
            builder.redirectErrorStream(true);
            Process p;
            p = builder.start();

            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = "";
            String nome = "";
            String servidor = "";

            while (true) {
                try {
                    line = r.readLine();
                } catch (IOException ex) {
                    Logger.getLogger(VPNRepositorio.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (line == null) {
                    break;
                }

                if (line.contains("Name")) {
                    nome = line.split(":")[1];
                    nome = nome.substring(1, nome.length());
                } else if (line.contains("Server")) {
                    servidor = line.split(":")[1];
                    servidor = servidor.substring(1, servidor.length());
                }

                if (nome != "" && servidor != "") {
                    VPN vpn = new VPN(nome, servidor, "");

                    listaVPN.add(vpn);
                    nome = "";
                    servidor = "";
                }

            }

        } catch (IOException ex) {
            Logger.getLogger(VPNRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaVPN;
    }

    @Override
    public VPN SelectServe(String server) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Create(VPN entidade) {

        try {
            ProcessBuilder builder;

            builder = new ProcessBuilder(
                    "powershell.exe", "Add-VpnConnection -Name \"'" + entidade.getNome() + "'\" -ServerAddress \"'" + entidade.getServer() + "'\" -TunnelType \"L2tp\" -EncryptionLevel \"Required\" -AuthenticationMethod MSChapv2 -L2tpPsk \"'" + entidade.getL2tpPsk() + "'\" -Force -RememberCredential -PassThru");

            builder.redirectErrorStream(true);
            Process p;
            p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
                line = r.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(VPNRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void Destroy(String name) {

        try {

            ProcessBuilder builder = new ProcessBuilder(
                    "powershell.exe", "Remove-VpnConnection -Name \"'" + name + "'\" -Force -PassThru");
            builder.redirectErrorStream(true);
            Process p;
            p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
                line = r.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }

        } catch (IOException ex) {
            Logger.getLogger(VPNRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void Update(VPN entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

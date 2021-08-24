/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurarvpn;

import classes.VPN;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import classes.VPNRepositorio;
import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;

/**
 *
 * @author AlexandreSCorreia
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button btnStart;

    @FXML
    private ProgressIndicator progress;

    @FXML
    private Label txtMsg;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {
            criaVPNs();
        } catch (Exception e) {
            btnStart.setVisible(false);
            txtMsg.setVisible(true);
            txtMsg.setText("Ocorreu algum erro inesperado, favor procurar o desenvolvedor do software e relatar o problema");
        }

    }

    private void criaVPNs() {
        new Thread() {

            @Override
            public void run() {
                btnStart.setVisible(false);
                progress.setVisible(true);
                VPNRepositorio vpn = new VPNRepositorio();
                List<VPN> list = vpn.FindAll();
                String server1 = "endereço da vpn";
                String server2 = "endereço da vpn";
                boolean ser1 = false;
                boolean ser2 = false;

                for (VPN validacao : list) {
                    if (validacao.getServer().equals(server1)) {
                        ser1 = true;
                    } else if (validacao.getServer().equals(server2)) {
                        ser2 = true;
                    }
                }

                for (VPN deleteVPN : list) {
                    vpn.Destroy(deleteVPN.getNome());
                }
               
                 if (ser1 == true && ser2 == true) {
                    vpn.Create(new VPN("", "", ""));
                } else if (ser1 == true && ser2 == false) {
                    vpn.Create(new VPN("VPN 2", server2, ""));
                } else if (ser1 == false && ser2 == true) {
                    vpn.Create(new VPN("", "", ""));
                } else if (ser1 == false && ser2 == false) {
                    vpn.Create(new VPN("", "", ""));
                }

                progress.setVisible(false);
                txtMsg.setVisible(true);
            }
        }.start();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}

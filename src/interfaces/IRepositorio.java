/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import java.util.List;
/**
 *
 * @author AlexandreSCorreia
 */
public interface IRepositorio<T> {
    
    
     List<T> FindAll();
     T SelectServe(String server);
     void Create(T entidade);
     void Destroy(String name);
     void Update(T entidade);
     
}

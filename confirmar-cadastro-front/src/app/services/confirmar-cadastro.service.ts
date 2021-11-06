import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ConfirmarCadastroService {

  constructor(
    private http: HttpClient
  ) { }

  public confirmarCadastro() {
    let msg: any = {
      "msg": "cadastro confirmado microservico & front"
    }

    this.http.post("http://localhost:8090/confirmar-cadastro/confirmar", msg).subscribe();
  }
}

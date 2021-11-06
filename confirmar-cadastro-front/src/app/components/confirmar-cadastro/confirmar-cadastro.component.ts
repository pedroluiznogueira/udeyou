import { Component, OnInit } from '@angular/core';
import { ConfirmarCadastroService } from 'src/app/services/confirmar-cadastro.service';

@Component({
  selector: 'app-confirmar-cadastro',
  templateUrl: './confirmar-cadastro.component.html',
  styleUrls: ['./confirmar-cadastro.component.css']
})
export class ConfirmarCadastroComponent implements OnInit {

  constructor(
    private confirmarCadastro: ConfirmarCadastroService
  ) { }

  ngOnInit(): void {
  }

  public emitirConfirmacao() {
    this.confirmarCadastro.confirmarCadastro();
  }

  goToLink(url: string){
    window.open(url, "_blank");
  }

}

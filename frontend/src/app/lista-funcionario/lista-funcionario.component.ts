import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { AppService } from '../app.service';
import { Router } from '@angular/router';
import { Funcionario } from '../model/funcionario.model';

@Component({
  selector: 'app-lista-funcionario',
  templateUrl: './lista-funcionario.component.html',
  styleUrls: ['./lista-funcionario.component.css']
})
export class ListaFuncionarioComponent implements OnInit {

  funcionario : Funcionario = new Funcionario();

  funcionarios= new Array<any>;

  funcionarioURL = 'http://localhost:8080/funcionario'

  constructor(private service: AppService){}

  ngOnInit(): void {
    this.service.getAll(this.funcionarioURL).subscribe(resposta => this.funcionarios = resposta);

    this.funcionario.cpf = ""
    this.funcionario.nome= ""
  }

  buscar(){
    let url : string = this.funcionarioURL + '/buscar?';
    if(this.funcionario.nome!=""){
      url+="nome="+ this.funcionario.nome + '&'
    }
    if(this.funcionario.cpf!=""){
      url+="cpf="+ this.funcionario.cpf + '&'
    }
    console.log(url)
    this.service.get(url).subscribe(resposta => {
        this.funcionarios = resposta;
    });
  }

  remover(url: string){
    this.service.remover(url);
    window.location.reload()
  }


}

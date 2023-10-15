import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { AppService } from '../app.service';
import { Router } from '@angular/router';
import { BuscaTarefa } from '../model/busca-tarefa.model';

@Component({
  selector: 'app-lista-tarefa',
  templateUrl: './lista-tarefa.component.html',
  styleUrls: ['./lista-tarefa.component.css']
})
export class ListaTarefaComponent implements OnInit {

  tarefaURL = 'http://localhost:8080/tarefa'

  buscaTarefa: BuscaTarefa = new BuscaTarefa();

  tarefas = new Array<any>;

  situacoes = new Array<any>

  constructor(private service: AppService, private router:Router){}

  ngOnInit(): void {
    this.service.getAll(this.tarefaURL).subscribe(resposta => this.tarefas = resposta);

    this.service.getAll("http://localhost:8080/tarefa/situacao").subscribe(resposta => this.situacoes = resposta)

    this.buscaTarefa.responsavel = "";
    this.buscaTarefa.tituloDes = "";
  }

  remover(url: string){
    this.service.remover(url);
    window.location.reload()
  }

  buscar(){
    let url : string = this.tarefaURL + '/buscar?';
    if(this.buscaTarefa.numero != null){
      url+="numero="+ this.buscaTarefa.numero + '&'
    }
    if(this.buscaTarefa.tituloDes != ""){
      url+="tituloDes="+ this.buscaTarefa.tituloDes + '&'
    }
    if(this.buscaTarefa.responsavel != ""){
      url+="responsavel="+ this.buscaTarefa.responsavel + '&'
    }
    if(this.buscaTarefa.situacao != null){
      url+="situacao="+ this.buscaTarefa.situacao + '&'
    }

    console.log(url);
    this.service.get(url).subscribe(resposta => {
        this.tarefas = resposta;
    });
  }

  concluir(url: string){
    this.service.concluir(url);
    window.location.reload()
  }

}

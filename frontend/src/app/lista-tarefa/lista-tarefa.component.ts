import { Component, OnInit } from '@angular/core';
import { AppService } from '../app.service';

@Component({
  selector: 'app-lista-tarefa',
  templateUrl: './lista-tarefa.component.html',
  styleUrls: ['./lista-tarefa.component.css']
})
export class ListaTarefaComponent implements OnInit {
  tarefas = new Array<any>;

  tarefaURL = 'http://localhost:8080/tarefa'

  constructor(private service: AppService){}

  ngOnInit(): void {
    this.service.getAll(this.tarefaURL).subscribe(resposta => this.tarefas = resposta);
  }

  remover(url: string){
    console.log(url)
    this.service.remover(url);
  }

}

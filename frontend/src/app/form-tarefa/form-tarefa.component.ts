import { Component, OnInit } from '@angular/core';
import { AppService } from '../app.service';
import { Tarefa } from '../model/tarefa.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-form-tarefa',
  templateUrl: './form-tarefa.component.html',
  styleUrls: ['./form-tarefa.component.css']
})
export class FormTarefaComponent implements OnInit {
  tarefaURL = 'http://localhost:8080/tarefa'
  funcionarioURL = 'http://localhost:8080/funcionario'

  resposta:any;

  tarefa : Tarefa = new Tarefa();

  funcionarios= new Array<any>;

  prioridades= new Array<any>;

  constructor(private service: AppService, private router : Router){}

  ngOnInit(): void {
    this.service.getAll(this.funcionarioURL).subscribe(resposta => this.funcionarios = resposta);

    this.service.getAll(this.tarefaURL + '/prioridade').subscribe(resposta => this.prioridades = resposta);
  }

  criar(){
    this.service.adicionar(this.tarefaURL, this.tarefa).subscribe((resultData: any) => {
      let i = 0;
      resultData.forEach((element: { defaultMessage: any; }) => {
        alert(element.defaultMessage)
        i++;
      });
      if(i == 0){
        this.router.navigateByUrl('/');
      }
    });
  }
}

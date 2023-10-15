import { Component, OnInit } from '@angular/core';
import { Tarefa } from '../model/tarefa.model';
import { AppService } from '../app.service';
import { ActivatedRoute, ActivatedRouteSnapshot, Router } from '@angular/router';

@Component({
  selector: 'app-editar-tarefa',
  templateUrl: './editar-tarefa.component.html',
  styleUrls: ['./editar-tarefa.component.css']
})
export class EditarTarefaComponent implements OnInit {
  tarefaURL = 'http://localhost:8080/tarefa';
  funcionarioURL = 'http://localhost:8080/funcionario'
  tarefaAux : string;

  tarefa : Tarefa = new Tarefa();

  funcionarios= new Array<any>;

  prioridades= new Array<any>;

  constructor(private service: AppService, private route: ActivatedRoute, private router: Router){
    const routeParams = this.route.snapshot.paramMap;
    this.tarefaAux = this.tarefaURL + '/' + routeParams.get('id');
  }


  ngOnInit(): void {

    this.service.getAll(this.funcionarioURL).subscribe(resposta => this.funcionarios = resposta);

    this.service.getAll(this.tarefaURL + '/prioridade').subscribe(resposta => this.prioridades = resposta);

    this.service.get(this.tarefaAux).subscribe(resposta => {
      this.tarefa.titulo = resposta.titulo;
      this.tarefa.descricao = resposta.descricao;
      this.tarefa.idFuncionario = resposta.responsavel.id;
      this.tarefa.deadline = resposta.deadline;
      switch(resposta.prioridade){
      case "Média":
        this.tarefa.prioridade = 0;
        break
      case "Baixa":
        this.tarefa.prioridade = 1;
        break
      case "Alta":
        this.tarefa.prioridade = 2;
        break
      default:
        this.tarefa.prioridade = -1;
    }
    });
  }

  editar(){
    this.service.adicionar(this.tarefaAux, this.tarefa).subscribe((resultData: any) => {
      let i = 0;
      console.log(resultData);
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

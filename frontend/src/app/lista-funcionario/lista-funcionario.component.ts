import { Component, OnInit } from '@angular/core';
import { AppService } from '../app.service';

@Component({
  selector: 'app-lista-funcionario',
  templateUrl: './lista-funcionario.component.html',
  styleUrls: ['./lista-funcionario.component.css']
})
export class ListaFuncionarioComponent implements OnInit {

  funcionario : any;

  funcionarios= new Array<any>;

  funcionarioURL = 'http://localhost:8080/funcionario'

  constructor(private service: AppService){}

  ngOnInit(): void {
    this.service.getAll(this.funcionarioURL).subscribe(resposta => this.funcionarios = resposta);
  }

  buscar(){
    this.service.get(this.funcionarioURL + '/1').subscribe(resposta => this.funcionarios = [resposta]);
  }
}

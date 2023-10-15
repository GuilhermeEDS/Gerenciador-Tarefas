import { Component } from '@angular/core';
import { Funcionario } from '../model/funcionario.model';
import { AppService } from '../app.service';

@Component({
  selector: 'app-form-funcionario',
  templateUrl: './form-funcionario.component.html',
  styleUrls: ['./form-funcionario.component.css']
})
export class FormFuncionarioComponent {
  funcionarioURL = 'http://localhost:8080/funcionario'

  funcionario : Funcionario = new Funcionario();

  constructor(private service: AppService){}

  criar(){
    this.service.adicionar(this.funcionarioURL, this.funcionario).subscribe();
  }
}

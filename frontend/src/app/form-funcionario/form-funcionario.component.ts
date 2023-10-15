import { Component } from '@angular/core';
import { Funcionario } from '../model/funcionario.model';
import { AppService } from '../app.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-form-funcionario',
  templateUrl: './form-funcionario.component.html',
  styleUrls: ['./form-funcionario.component.css']
})
export class FormFuncionarioComponent {
  funcionarioURL = 'http://localhost:8080/funcionario'

  funcionario : Funcionario = new Funcionario();

  constructor(private service: AppService, private router : Router){}

  criar(){
    this.service.adicionar(this.funcionarioURL, this.funcionario).subscribe((resultData: any) => {
      let i = 0;
      resultData.forEach((element: { defaultMessage: any; }) => {
        alert(element.defaultMessage)
        i++;
      });
      if(i == 0){
        this.router.navigateByUrl('/funcionario');
      }
    });
  }
}

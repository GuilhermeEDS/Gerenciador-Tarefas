import { Component, OnInit } from '@angular/core';
import { AppService } from '../app.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  cpf : string = "";
  senha : string = "";

  constructor(private service : AppService){

  }

  login(){
    console.log(this.cpf + this.senha)
    let bodyData = {
      cpf: this.cpf,
      senha: this.senha,
    };
    this.service.login(bodyData)
  }

}

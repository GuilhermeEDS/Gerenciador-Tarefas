import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  http: HttpClient;

  constructor(http: HttpClient,private router : Router) {
    this.http = http;
  }

  get(url: string){
    return this.http.get<any>(url);
  }

  getAll(url : string) {
    return this.http.get<Array<any>>(url);
  }

  adicionar (url : string, object: any): Observable<Object> {
    return this.http.post<Object>(url, object);
  }

  remover(url : string){
    this.http.delete(url).subscribe();
  }

  login(data : any){
    this.http.post("http://localhost:8080/login", data).subscribe(  (resultData: any) => {
        console.log(resultData);

        if (resultData.mensagem == "Cpf não cadastrado")
        {

          alert("Cpf não cadastrado");


        }
        else if(resultData.mensagem == "Logado com sucesso")

         {
          this.router.navigateByUrl('/tarefa');
        }
        else
        {
          alert("Senha incorreta");
        }
      });
  }

}

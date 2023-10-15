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

  concluir(url : string){
    this.http.post(url, null).subscribe();
  }
}

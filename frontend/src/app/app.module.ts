import { NgModule, OnInit } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListaTarefaComponent } from './lista-tarefa/lista-tarefa.component';
import { ListaFuncionarioComponent } from './lista-funcionario/lista-funcionario.component';
import { FormFuncionarioComponent } from './form-funcionario/form-funcionario.component';
import { FormTarefaComponent } from './form-tarefa/form-tarefa.component';
import { EditarFuncionarioComponent } from './editar-funcionario/editar-funcionario.component';
import { EditarTarefaComponent } from './editar-tarefa/editar-tarefa.component';

@NgModule({
  declarations: [
    AppComponent,
    ListaTarefaComponent,
    ListaFuncionarioComponent,
    FormFuncionarioComponent,
    FormTarefaComponent,
    EditarFuncionarioComponent,
    EditarTarefaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule implements OnInit {
  tarefa : any;

  ngOnInit(): void {
      this.tarefa = {};
  }

  criar(){}
 }

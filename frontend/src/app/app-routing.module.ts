import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListaTarefaComponent } from './lista-tarefa/lista-tarefa.component';
import { FormTarefaComponent } from './form-tarefa/form-tarefa.component';
import { ListaFuncionarioComponent } from './lista-funcionario/lista-funcionario.component';
import { FormFuncionarioComponent } from './form-funcionario/form-funcionario.component';
import { EditarTarefaComponent } from './editar-tarefa/editar-tarefa.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {
  	path: '',
  	component: LoginComponent
  },
  {
  	path: 'tarefa',
  	component: ListaTarefaComponent
  },
  {
  	path: 'tarefa/editar/:id',
  	component: EditarTarefaComponent
  },
  {
  	path: 'tarefa/novo',
  	component: FormTarefaComponent
  },
  {
  	path: 'funcionario',
  	component: ListaFuncionarioComponent
  },
  {
  	path: 'funcionario/novo',
  	component: FormFuncionarioComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

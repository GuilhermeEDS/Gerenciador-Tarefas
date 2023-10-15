import { Component } from '@angular/core';
import { Funcionario } from '../model/funcionario.model';
import { AppService } from '../app.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-editar-funcionario',
  templateUrl: './editar-funcionario.component.html',
  styleUrls: ['./editar-funcionario.component.css']
})
export class EditarFuncionarioComponent {

  funcionarioURL = 'http://localhost:8080/funcionario';
  funcionarioAux : string;

  funcionario : Funcionario = new Funcionario();

  constructor(private service: AppService, private route: ActivatedRoute, private router: Router){
    const routeParams = this.route.snapshot.paramMap;
    this.funcionarioAux = this.funcionarioURL + '/' + routeParams.get('id');
  }


  ngOnInit(): void {

    this.service.get(this.funcionarioAux).subscribe(resposta => {
      this.funcionario.nome = resposta.nome;
      this.funcionario.cpf = resposta.cpf;
    });

  }
  editar(){
    this.service.adicionar(this.funcionarioAux, this.funcionario).subscribe((resultData: any) => {
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

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaFuncionarioComponent } from './lista-funcionario.component';

describe('ListaFuncionarioComponent', () => {
  let component: ListaFuncionarioComponent;
  let fixture: ComponentFixture<ListaFuncionarioComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListaFuncionarioComponent]
    });
    fixture = TestBed.createComponent(ListaFuncionarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

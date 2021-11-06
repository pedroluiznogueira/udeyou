import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormularioAdminComponent } from './formulario-admin.component';

describe('FormularioAdminComponent', () => {
  let component: FormularioAdminComponent;
  let fixture: ComponentFixture<FormularioAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormularioAdminComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormularioAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { TestBed } from '@angular/core/testing';

import { ConfirmarCadastroService } from './confirmar-cadastro.service';

describe('ConfirmarCadastroService', () => {
  let service: ConfirmarCadastroService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ConfirmarCadastroService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

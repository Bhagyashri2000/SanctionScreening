import { TestBed } from '@angular/core/testing';

import { AllTransactionService } from './all-transaction.service';

describe('AllTransactionService', () => {
  let service: AllTransactionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AllTransactionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

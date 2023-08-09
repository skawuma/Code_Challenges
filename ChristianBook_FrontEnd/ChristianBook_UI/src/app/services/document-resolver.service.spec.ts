import { TestBed } from '@angular/core/testing';

import { DocumentResolverService } from './document-resolver.service';

describe('DocumentResolverService', () => {
  let service: DocumentResolverService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DocumentResolverService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

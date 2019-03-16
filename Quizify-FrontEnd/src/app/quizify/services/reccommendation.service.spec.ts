import { TestBed } from '@angular/core/testing';

import { ReccommendationService } from './reccommendation.service';

describe('ReccommendationService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ReccommendationService = TestBed.get(ReccommendationService);
    expect(service).toBeTruthy();
  });
});

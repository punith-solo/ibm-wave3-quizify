import { TestBed } from '@angular/core/testing';

import { SingleplayerService } from './singleplayer.service';

describe('SingleplayerService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SingleplayerService = TestBed.get(SingleplayerService);
    expect(service).toBeTruthy();
  });
});

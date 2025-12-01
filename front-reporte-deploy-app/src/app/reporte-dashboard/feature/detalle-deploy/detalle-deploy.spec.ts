import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalleDeploy } from './detalle-deploy';

describe('DetalleDeploy', () => {
  let component: DetalleDeploy;
  let fixture: ComponentFixture<DetalleDeploy>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DetalleDeploy]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DetalleDeploy);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DemoServiceService } from './demo-service.service';
import { DemoCompComponent } from './demo-comp/demo-comp.component';

describe('DemoServiceService', () => {
  let service: DemoServiceService;
  let component:DemoCompComponent;
  let fixture:ComponentFixture<DemoCompComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DemoServiceService);
    // service = TestBed.get(DemoServiceService);
    //FOR OLDER VERSIONS

    fixture=TestBed.createComponent(DemoCompComponent);
    component = fixture.componentInstance;
    

  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should have invoked',()=>{
    // spyOn(service,'doSomeTask')
    component.method();
    expect(service.doSomeTask).toHaveBeenCalled();
  })
});

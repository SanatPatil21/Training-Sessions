import { Injectable } from '@angular/core';
import { Employee } from './employee.model';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  selectedEmployee:Employee={};
  employees:Employee[]=[];
  url:string="http://localhost:8090/employees"


  constructor(private http:HttpClient) { }


  postEmployee(emp:Employee):Observable<any>
  {
    return this.http.post(this.url,emp)
  }

  putEmployee(emp:Employee):Observable<any>
  {
    return this.http.put(this.url,emp)
  }

  getAllEmployees(){
    return this.http.get(this.url)
  }

  deleteEmployee(id:number){
    return this.http.delete(this.url+"/"+id)

  }
}

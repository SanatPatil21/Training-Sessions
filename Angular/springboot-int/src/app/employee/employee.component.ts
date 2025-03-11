import { Component } from '@angular/core';
import { EmployeeService } from '../shared/employee.service';
import { NgForm } from '@angular/forms';
import { Employee } from '../shared/employee.model';

@Component({
  selector: 'app-employee',
  standalone: false,
  templateUrl: './employee.component.html',
  styleUrl: './employee.component.css',
  providers: [EmployeeService]
})
export class EmployeeComponent {

  update: boolean = false;

  constructor(public empService: EmployeeService) { }

  ngOnInit(): void {
    this.resetForm();
  }

  onSubmit(form: NgForm) {
    console.log(`Submitted User:`, form.value);

    if (!this.update) {
      if (this.empService.employees.some(entryEmp => entryEmp.eid === form.value.eid)) {
        alert(`ID already exists`);
        this.resetForm(form);
        return;
      }

      this.empService.postEmployee(form.value).subscribe((res) => {
        this.resetForm(form);
        console.log("Employee record Inserted");
      })
    } else {
      this.empService.putEmployee(form.value).subscribe((res) => {
        this.resetForm(form);
        console.log("Employee record Updated");
        this.update = false;

      })

    }


  }


  resetForm(form?: NgForm) {
    if (form) {
      form.reset();
    }
    this.empService.selectedEmployee = new Employee();

    this.refreshEmployees();
  }

  refreshEmployees() {
    this.empService.getAllEmployees().subscribe((res) => {
      this.empService.employees = res as Employee[];
    })
  }

  updateEmp(emp: Employee) {
    this.empService.selectedEmployee = emp;
    this.update = true;
  }

  deleteEmp(id: number | undefined) {
    if (id) {
      if (confirm("Do you really want to delete ?")) {
        this.empService.deleteEmployee(id).subscribe((res) => {
          this.resetForm();
        })
      }
    }

  }

}

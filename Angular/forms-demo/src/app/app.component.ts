import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { TemplateDrivenComponent } from "./components/template-driven/template-driven.component";
import { ReactiveFormsComponent } from "./components/reactive-forms/reactive-forms.component";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, TemplateDrivenComponent, ReactiveFormsComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'forms-demo';
}

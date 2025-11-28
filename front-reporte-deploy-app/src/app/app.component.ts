import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Dialog } from 'primeng/dialog';
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';


@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Dialog, ButtonModule, InputTextModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'front-reporte-deploy-app';

  visible: boolean = false;

  showDialog() {
    this.visible = true;
  }

}

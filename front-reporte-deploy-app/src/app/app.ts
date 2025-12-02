import { Component, HostBinding, OnInit, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HlmButtonImports } from '@spartan-ng/helm/button';

@Component({
  selector: 'app-root',
  imports: [
    RouterOutlet, 
    HlmButtonImports
  ],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App implements OnInit{
  protected readonly title = signal('front-reporte-deploy-app');

  darkMode = signal<boolean>(false);

  @HostBinding('class.dark') get isDarkMode() {
    return this.darkMode();
  }

  ngOnInit() {
    // Detecta preferencia inicial
    this.applyTheme();
    
    // Escucha cambios en preferencia del sistema
    window.matchMedia('(prefers-color-scheme: dark)')
      .addEventListener('change', () => this.applyTheme());
  }

  private applyTheme() {
    const isDark = window.matchMedia('(prefers-color-scheme: dark)').matches;
    
    if (isDark) {
      document.documentElement.classList.add('dark');
    } else {
      document.documentElement.classList.remove('dark');
    }
  }


}

import { Component } from '@angular/core';
import { HlmSidebarImports } from '@spartan-ng/helm/sidebar';
import { LucideAngularModule, Rocket } from 'lucide-angular';

@Component({
  selector: 'app-side-bar',
  imports: [HlmSidebarImports, LucideAngularModule],
  templateUrl: './side-bar.html',
  styleUrl: './side-bar.css',
})
export class SideBar {
  readonly rocket = Rocket;
}

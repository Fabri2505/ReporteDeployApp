import { Component } from '@angular/core';
import { SideBar } from '../side-bar/side-bar';
import { HlmSidebarImports } from '@spartan-ng/helm/sidebar';

@Component({
  selector: 'app-main-layout',
  imports: [SideBar, HlmSidebarImports],
  templateUrl: './main-layout.html',
  styleUrl: './main-layout.css',
})
export class MainLayout {

}

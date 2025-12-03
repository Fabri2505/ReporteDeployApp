import { Component } from '@angular/core';
import { HlmSidebarImports } from '@spartan-ng/helm/sidebar';
import { LucideAngularModule, Rocket, House, Inbox, Calendar, Search, Settings, FolderGit2, ChevronDown} from 'lucide-angular';
import { HlmCollapsibleImports } from '@spartan-ng/helm/collapsible';

@Component({
  selector: 'app-side-bar',
  imports: [HlmSidebarImports, LucideAngularModule, HlmCollapsibleImports],
  templateUrl: './side-bar.html',
  styleUrl: './side-bar.css',
})
export class SideBar {
  readonly rocket = Rocket;
  readonly house = House;
  readonly inbox = Inbox;
  readonly calendar = Calendar;
  readonly search = Search;
  readonly settings = Settings;
  readonly folderOpen = FolderGit2;
  readonly flecha = ChevronDown;

  protected readonly _itemsNav = [
    {
      title: 'Dashboard',
      url: '#',
      icon: this.house,
    },
    {
      title: 'Reportes',
      url: '#',
      icon: this.inbox,
    },
    {
      title: 'Responsables',
      url: '#',
      icon: this.calendar,
    },
    {
      title: 'Configuración',
      url: '#',
      icon: this.settings,
    },
  ];

  protected readonly _itemsProject = [
    {
      title: 'Proyectos',
      defaultOpen: true,
      items:[
        {
          title:"Creacion de clientes"
        },
        {
          title:"Creacion de pedido"
        },
        {
          title:"Marcaciones"
        }
      ]
    }
  ];

}

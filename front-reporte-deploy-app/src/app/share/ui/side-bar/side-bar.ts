import { Component } from '@angular/core';
import { HlmSidebarImports } from '@spartan-ng/helm/sidebar';
import { LucideAngularModule, Rocket, House, Inbox, Calendar, Search, Settings, FolderGit2, ChevronDown} from 'lucide-angular';
import { HlmCollapsibleImports } from '@spartan-ng/helm/collapsible';

import { 
  lucideRocket,
  lucideHome,
  lucideInbox,
  lucideCalendar,
  lucideSearch,
  lucideSettings,
  lucideFolderGit2,
  lucideChevronDown
} from '@ng-icons/lucide';
import { NgIcon, provideIcons } from '@ng-icons/core';
import { HlmIcon } from '@spartan-ng/helm/icon';

@Component({
  selector: 'app-side-bar',
  imports: [HlmSidebarImports, NgIcon, HlmIcon, HlmCollapsibleImports],
  templateUrl: './side-bar.html',
  styleUrl: './side-bar.css',
  providers: [
    provideIcons({
      lucideRocket,
      lucideHome,
      lucideInbox,
      lucideCalendar,
      lucideSearch,
      lucideSettings,
      lucideFolderGit2,
      lucideChevronDown
    })
  ],
})
export class SideBar {
  readonly rocket = 'lucideRocket';
  readonly house = 'lucideHome';
  readonly inbox = 'lucideInbox';
  readonly calendar = 'lucideCalendar';
  readonly search = 'lucideSearch';
  readonly settings = 'lucideSettings';
  readonly folderOpen = 'lucideFolderGit2';
  readonly flecha = 'lucideChevronDown';

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

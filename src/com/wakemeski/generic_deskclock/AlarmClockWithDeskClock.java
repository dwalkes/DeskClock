package com.wakemeski.generic_deskclock;

import com.wakemeski.generic_deskclock.R;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

/**
 * Extends the base alarm clock picker dialog to add the desk clock dialog at the bottom of the screen,
 * for applications which use this deskclock screen (similar to the base alarm clock ap)
 * @author dan
 *
 */
public class AlarmClockWithDeskClock extends AlarmClockBase {

	protected void setContentView() {
		setContentView(R.layout.alarm_clock_with_deskclock);
	}
    
	@Override
	protected void updateLayout() {
		super.updateLayout();
		ImageButton deskClock = (ImageButton) findViewById(R.id.desk_clock_button);
			deskClock.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(AlarmClockWithDeskClock.this, DeskClock.class));
            }
			});
	}
			
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.alarm_list_menu_deskclock, menu);
        return super.onCreateOptionsMenu(menu);
    }


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		if (item.getItemId() == R.id.menu_item_desk_clock) {
			startActivity(new Intent(this, DeskClock.class));
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

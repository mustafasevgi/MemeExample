package com.msevgi.memeex;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;

import us.sigsegv.android.maximumultimatememecreatorxturbo.R;

import android.app.SearchManager;
import android.app.SearchManager.OnCancelListener;
import android.app.SearchManager.OnDismissListener;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;

public class MemeTemplateGallery extends FragmentActivity {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	private ArrayList<String> mTemplateUris;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mTemplateUris = getTemplateUris();
		setContentView(R.layout.activity_meme_template_gallery);

		// Show the Up button in the action bar.
		getActionBar().setDisplayHomeAsUpEnabled(true);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
		// Get the intent, verify the action and get the query
	    Intent intent = getIntent();
	    if(intent != null){
		    if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
		      String query = intent.getStringExtra(SearchManager.QUERY);
		      doMySearch(query);
		    }
	    }
	    if(savedInstanceState != null){
	    	String query = savedInstanceState.getString("query");
			if(query != null){
				doMySearch(query);
			}
	    }
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		 Intent intent = getIntent();
		 if(intent != null){
			 String query = null;
			    if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
			      query = intent.getStringExtra(SearchManager.QUERY);
			    }
			    if(query != null){
			    	outState.putString("query", query);
			    }
		 }
	}
	
	private void doMySearch(String query) {
		ArrayList<String> itemsToRemove = new ArrayList<String>();
		for(String item : this.mTemplateUris){
			if(!((String)mSectionsPagerAdapter.extractMeaningfulTitleFromFileName(item)).toLowerCase(Locale.ENGLISH).contains(query.toLowerCase(Locale.ENGLISH))){
				itemsToRemove.add(item);
			}
		}
		for(String remove : itemsToRemove){
			this.mTemplateUris.remove(remove);
		}
		mViewPager.getAdapter().notifyDataSetChanged();
	}

	/**
	 * Generated by automation DO NOT EDIT BY HAND
	 * @return
	 */

	private ArrayList<String> getTemplateUris() {
		ArrayList<String> templates = new ArrayList<String>();
		templates.add("meme_templates/10_guy.jpg");
		templates.add("meme_templates/ancient_aliens.jpg");
		templates.add("meme_templates/annoying_facebook_girl.jpg");
		templates.add("meme_templates/bad_luck_brian.jpg");
		templates.add("meme_templates/bear_grylls.jpg");
		templates.add("meme_templates/brace_yourselves_x_is_coming.jpg");
		templates.add("meme_templates/conspiracy_keanu.jpg");
		templates.add("meme_templates/creepy_condescending_wonka.jpg");
		templates.add("meme_templates/don_t_you_squidward.jpg");
		templates.add("meme_templates/dwight_schrute.jpg");
		templates.add("meme_templates/first_world_problems.jpg");
		templates.add("meme_templates/forever_alone.jpg");
		templates.add("meme_templates/futurama_fry.jpg");
		templates.add("meme_templates/BusinessCat2.jpg");
		templates.add("meme_templates/good_guy_greg.jpg");
		templates.add("meme_templates/grandma_finds_the_internet.jpg");
		templates.add("meme_templates/grumpy_cat.jpg");
		templates.add("meme_templates/buzz_lightyear_explaining.jpg");
		templates.add("meme_templates/i_ll_just_wait_here.jpg");
		templates.add("meme_templates/insanity_wolf.jpg");
		templates.add("meme_templates/joseph_ducreux.jpg");
		templates.add("meme_templates/come_to_bed.jpg");
		templates.add("meme_templates/kill_yourself_guy.jpg");
		templates.add("meme_templates/matrix_morpheus.jpg");
		templates.add("meme_templates/michael_jordan_rings_u_mad_bro.jpg");
		templates.add("meme_templates/neil_degrasse_tyson.jpg");
		templates.add("meme_templates/one_does_not_simply.jpg");
		templates.add("meme_templates/challenge.jpg");
		templates.add("meme_templates/overly_attached_girlfriend.jpg");
		templates.add("meme_templates/philosoraptor.jpg");
		templates.add("meme_templates/dr_evil_pinky.jpg");
		templates.add("meme_templates/put_it_somewhere_else_patrick.jpg");
		templates.add("meme_templates/say_that_again_i_dare_you.jpg");
		templates.add("meme_templates/scumbag_steve.jpg");
		templates.add("meme_templates/dr_evil_bunny_quotes.jpg");
		templates.add("meme_templates/skeptical_baby.jpg");
		templates.add("meme_templates/slowpoke.jpg");
		templates.add("meme_templates/socially_awkward_penguin.jpg");
		templates.add("meme_templates/success_kid.jpg");
		templates.add("meme_templates/sudden_clarity_clarence.jpg");
		templates.add("meme_templates/super_cool_ski_instructor.jpg");
		templates.add("meme_templates/ted.jpg");
		templates.add("meme_templates/the_most_interesting_man_in_the_world.jpg");
		templates.add("meme_templates/third_world_skeptical_kid.jpg");
		templates.add("meme_templates/third_world_success_kid.jpg");
		templates.add("meme_templates/too_damn_high.jpg");
		templates.add("meme_templates/unhelpful_high_school_teacher.jpg");
		templates.add("meme_templates/x_all_the_y.jpg");
		templates.add("meme_templates/y_u_no.jpg");
		templates.add("meme_templates/yao_ming.jpg");
		templates.add("meme_templates/yo_dawg_heard_you.jpg");
		templates.add("meme_templates/blank_advice_animal.jpg");
		templates.add("meme_templates/ridiculously_photogenic_guy.jpg");
		return templates;
	}
	
	/**
	 * End of automated generated content DO NOT EDIT ABOVE BY HAND
	 */
	
	/**
     * Get bitmap from gallery
     * @throws java.io.IOException
     */
	
    protected Bitmap getBitmapFromAsset(String strName) throws IOException
    {
        AssetManager assetManager = getAssets();

        InputStream istr = assetManager.open(strName);
        Bitmap bitmap = BitmapFactory.decodeStream(istr);
        istr.close();

        return bitmap;
    }

	/* (non-Javadoc)
	 * @see android.support.v4.app.FragmentActivity#onNewIntent(android.content.Intent)
	 */
	@Override
	protected void onNewIntent(Intent intent) {
		if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
		      String query = intent.getStringExtra(SearchManager.QUERY);
		      doMySearch(query);
		}
		super.onNewIntent(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_meme_template_gallery, menu);
		// Get the SearchView and set the searchable configuration
	    SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
	    searchManager.setOnCancelListener(new OnCancelListener(){
	    	

			@Override
			public void onCancel() {
				resetList();
				
			}
	    });
	    searchManager.setOnDismissListener(new OnDismissListener(){


			@Override
			public void onDismiss() {
				resetList();
				
			}
	    });
	    SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
	    searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
	    searchView.setIconifiedByDefault(false); // Do not iconify the widget; expand it by default
		return true;
	}

	protected void resetList() {
		this.mTemplateUris = getTemplateUris();
		mViewPager.getAdapter().notifyDataSetChanged();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		case R.id.menu_settings:
			Intent i = new Intent(this, SettingsActivity.class);
			startActivity(i);
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a DummySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
			Fragment fragment = new DummySectionFragment();
			Bundle args = new Bundle();
			args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position);
			fragment.setArguments(args);
			return fragment;
		}

		@Override
		public int getCount() {
			return mTemplateUris.size();
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return extractMeaningfulTitleFromFileName(MemeTemplateGallery.this.mTemplateUris.get(position));
		}

		public CharSequence extractMeaningfulTitleFromFileName(String path) {
			String filename = new File(path).getName();
			String[] parts = filename.split("\\.");
			String name = parts[0];
			String spacesAdded = name.replace("_", " ");
			String ifIll = spacesAdded.replace("i ll", "i'll");
			String ifDont = ifIll.replace("don t", "don't");
			String initialCapitalized = capitalizeString(ifDont);
			String replaceWrongIll = initialCapitalized.replace("I'Ll", "I'll");
			return replaceWrongIll.replace("Don'T", "Don't");
		}
		
		public String capitalizeString(String string) {
			  char[] chars = string.toLowerCase(Locale.getDefault()).toCharArray();
			  boolean found = false;
			  for (int i = 0; i < chars.length; i++) {
			    if (!found && Character.isLetter(chars[i])) {
			      chars[i] = Character.toUpperCase(chars[i]);
			      found = true;
			    } else if (Character.isWhitespace(chars[i]) || chars[i]=='.' || chars[i]=='\'') { // You can add other chars here
			      found = false;
			    }
			  }
			  return String.valueOf(chars);
			}
		
	}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class DummySectionFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";
		protected static final String TAG = DummySectionFragment.class.getSimpleName();

		public DummySectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			// Create a new TextView and set its text to the fragment's section
			// number argument value.
			ImageView imageView = new ImageView(getActivity());
			int sectionNumber = getArguments().getInt(
					ARG_SECTION_NUMBER);
			String templatePath = ((MemeTemplateGallery)getActivity()).mTemplateUris.get(sectionNumber);
			Bitmap b = null;
			try {
				b = ((MemeTemplateGallery)getActivity()).getBitmapFromAsset(templatePath);
				imageView.setImageBitmap(b);
			} catch (IOException e) {
				Log.e(TAG, "Couldn't find that image!");
				e.printStackTrace();
			}
			imageView.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					int sectionNumber = getArguments().getInt(
							ARG_SECTION_NUMBER);
					String templatePath = ((MemeTemplateGallery)getActivity()).mTemplateUris.get(sectionNumber);
					Bitmap b = null;
					try {
						b = ((MemeTemplateGallery)getActivity()).getBitmapFromAsset(templatePath);
						((ImageView)arg0).setImageBitmap(b);
					} catch (IOException e) {
						Log.e(TAG, "Couldn't find that image!");
						e.printStackTrace();
					}
				     String res = FileUtilsHelper.saveBitmapAsJpeg(b, getActivity());
				     Log.d(TAG,"File Path: " + res);
					Intent editImage = new Intent(getActivity(), EditMemeImage.class);
					editImage.putExtra("com.samsung.smcl.maximumultimatememecreatorxturbo.path", res);
					editImage.putExtra("com.samsung.smcl.maximumultimatememecreatorxturbo.video",false);
					startActivity(editImage);
				}
				
			});
			return imageView;
		}
	}

}

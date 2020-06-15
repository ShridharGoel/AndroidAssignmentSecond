package com.shridhar.androidassignmentsecond;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.shridhar.androidassignmentsecond.Model.Card;
import com.shridhar.androidassignmentsecond.Model.CardDetails;
import com.shridhar.androidassignmentsecond.Model.Ctum;
import com.shridhar.androidassignmentsecond.Model.Entity;
import com.shridhar.androidassignmentsecond.Model.Entity_;

import java.util.ArrayList;
import java.util.List;

public class MultiViewTypeAdapter extends RecyclerView.Adapter {

    Context mContext;
    int total_types;
    private ArrayList<CardDetails> dataSet;

    public MultiViewTypeAdapter(ArrayList<CardDetails> data, Context context) {
        this.dataSet = data;
        this.mContext = context;
        total_types = dataSet.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hc1, parent, false);
                return new HC1TypeViewHolder(view);
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hc3, parent, false);
                return new HC3TypeViewHolder(view);
            case 2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hc4, parent, false);
                return new HC4TypeViewHolder(view);
            case 3:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hc5, parent, false);
                return new HC5TypeViewHolder(view);
            case 4:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hc6, parent, false);
                return new HC6TypeViewHolder(view);

        }

        return null;
    }

    @Override
    public int getItemViewType(int position) {
        switch (dataSet.get(position).getDesignType()) {
            case "HC1":
                return 0;
            case "HC3":
                return 1;
            case "HC4":
                return 2;
            case "HC5":
                return 3;
            case "HC6":
                return 4;
        }
        return 0;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CardDetails cardDetails = dataSet.get(position);

        if (cardDetails != null) {
            switch (cardDetails.getDesignType()) {
                case "HC1":
                    if (cardDetails.getIsScrollable()) {
                        addCardsScrollable(cardDetails, ((HC1TypeViewHolder) holder).hc1Layout, 250, holder);
                    } else {
                        addCardsNonScrollable(cardDetails, ((HC1TypeViewHolder) holder).hc1Layout, 250, holder);
                    }
                    break;
                case "HC3":
                    if (cardDetails.getIsScrollable()) {
                        addCardsScrollable(cardDetails, ((HC3TypeViewHolder) holder).hc3Layout, 850, holder);
                    } else {
                        addCardsNonScrollable(cardDetails, ((HC3TypeViewHolder) holder).hc3Layout, 850, holder);
                    }

                    break;
                case "HC4":
                    if (cardDetails.getIsScrollable()) {
                        addCardsScrollable(cardDetails, ((HC4TypeViewHolder) holder).hc4Layout, 850, holder);
                    } else {
                        addCardsNonScrollable(cardDetails, ((HC4TypeViewHolder) holder).hc4Layout, 850, holder);
                    }
                    break;
                case "HC5":
                    if (cardDetails.getIsScrollable()) {
                        addCardsScrollable(cardDetails, ((HC5TypeViewHolder) holder).hc5Layout, 400, holder);
                    } else {
                        addCardsNonScrollable(cardDetails, ((HC5TypeViewHolder) holder).hc5Layout, 400, holder);
                    }
                    break;
                case "HC6":
                    if (cardDetails.getIsScrollable()) {
                        addCardsScrollable(cardDetails, ((HC6TypeViewHolder) holder).hc6Layout, 250, holder);
                    } else {
                        addCardsNonScrollable(cardDetails, ((HC6TypeViewHolder) holder).hc6Layout, 250, holder);
                    }
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    private void addCardsScrollable(CardDetails cardDetails, LinearLayout hcLayout, int height, RecyclerView.ViewHolder holder) {
        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(hcLayout.getContext());
        LinearLayout.LayoutParams hsvparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, height);
        hsvparams.setMargins(10, 0, 10, 20);
        horizontalScrollView.setClipChildren(false);
        horizontalScrollView.setLayoutParams(hsvparams);

        LinearLayout linearLayout = new LinearLayout(horizontalScrollView.getContext());
        LinearLayout.LayoutParams llparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, height);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setClipChildren(false);
        linearLayout.setLayoutParams(llparams);

        FrameLayout frameLayout = new FrameLayout(linearLayout.getContext());
        frameLayout.setClipChildren(false);

        LinearLayout linearLayoutHidden = new LinearLayout(hcLayout.getContext());
        LinearLayout.LayoutParams llhparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, height);
        linearLayoutHidden.setOrientation(LinearLayout.VERTICAL);
        linearLayoutHidden.setBackgroundColor(Color.WHITE);
        linearLayoutHidden.setPadding(10, 10, 10, 10);
        linearLayoutHidden.setLayoutParams(llhparams);

        frameLayout.addView(linearLayoutHidden);

        for (int i = 0; i < cardDetails.getCards().size(); i++) {
            CardView cardView = new CardView(linearLayout.getContext());
            addCardView(cardView, cardDetails, i, height);
            cardView.setClipChildren(false);

            if (cardDetails.getDesignType().equals("HC3")) {
                cardView.setOnLongClickListener(view -> {
                    cardView.setX(linearLayout.getX() + 280f);
                    addHiddenIcons(linearLayoutHidden, cardDetails, frameLayout, holder);
                    linearLayoutHidden.bringToFront();
                    return true;
                });
            }

            Card card = cardDetails.getCards().get(i);

            cardView.setOnClickListener(view -> {
                Utils.openLink(cardView.getContext(), card.getUrl());
            });

            linearLayout.addView(cardView);
        }

        frameLayout.addView(linearLayout);
        horizontalScrollView.addView(frameLayout);
        hcLayout.addView(horizontalScrollView);
    }

    private void addCardsNonScrollable(CardDetails cardDetails, LinearLayout hcLayout, int height, RecyclerView.ViewHolder holder) {
        LinearLayout linearLayout = new LinearLayout(hcLayout.getContext());
        LinearLayout.LayoutParams llparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, height);
        llparams.setMargins(10, 0, 10, 20);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setClipChildren(false);
        linearLayout.setLayoutParams(llparams);

        FrameLayout frameLayout = new FrameLayout(linearLayout.getContext());
        frameLayout.setClipChildren(false);

        LinearLayout linearLayoutHidden = new LinearLayout(hcLayout.getContext());
        LinearLayout.LayoutParams llhparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, height);
        linearLayoutHidden.setOrientation(LinearLayout.VERTICAL);
        linearLayoutHidden.setBackgroundColor(Color.WHITE);
        linearLayoutHidden.setPadding(10, 10, 10, 10);
        linearLayoutHidden.setLayoutParams(llhparams);

        frameLayout.addView(linearLayoutHidden);

        for (int i = 0; i < cardDetails.getCards().size(); i++) {
            CardView cardView = new CardView(linearLayout.getContext());
            addCardView(cardView, cardDetails, i, height);

            cardView.setClipChildren(false);

            if (cardDetails.getDesignType().equals("HC3")) {
                cardView.setOnLongClickListener(view -> {
                    cardView.setX(linearLayout.getX() + 280f);
                    addHiddenIcons(linearLayoutHidden, cardDetails, frameLayout, holder);
                    linearLayoutHidden.bringToFront();
                    return true;
                });
            }

            Card card = cardDetails.getCards().get(i);

            cardView.setOnClickListener(view -> {
                Utils.openLink(cardView.getContext(), card.getUrl());
            });

            linearLayout.addView(cardView);
        }

        frameLayout.addView(linearLayout);
        hcLayout.addView(frameLayout);
    }

    private void addCardView(CardView cardView, CardDetails cardDetails, int i, int height) {
        LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, height, 1.0f);
        lparams.setMargins(5, 20, 5, 20);
        cardView.setRadius(15.0f);
        cardView.setCardElevation(7.0f);
        cardView.setUseCompatPadding(true);
        cardView.setLayoutParams(lparams);
        Card card = cardDetails.getCards().get(i);

        if (card.getBgColor() != null)
            cardView.setCardBackgroundColor(Color.parseColor(card.getBgColor()));

        if (card.getBgGradient() != null) {
            GradientDrawable gd = new GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT,
                    new int[]{Color.parseColor(card.getBgGradient().getColors().get(0)), Color.parseColor(card.getBgGradient().getColors().get(1))});
            gd.setCornerRadius(15.0f);

            cardView.setBackground(gd);
        }

        if (cardDetails.getDesignType().equals("HC4")) {
            addIcon(cardView, card);
            addTitle(cardView, card, (int) (height / 2.15), true);
            addDesc(cardView, card, (int) (height / (1.75)), true);
            addCta(cardView, card, (int) (height / 1.5), true);
        } else if (cardDetails.getDesignType().equals("HC3")) {
            addTitle(cardView, card, (int) (height / 2.5), false);
            addDesc(cardView, card, (height / (2)), false);
            addCta(cardView, card, (int) (height / 1.5), false);
        } else if (cardDetails.getDesignType().equals("HC1")) {
            addIconTitleAndDescription(cardView, card, false);
        } else if (cardDetails.getDesignType().equals("HC6")) {
            addIconTitleAndDescription(cardView, card, true);
        }

        if (card.getBgImage() != null) {
            Glide.with(cardView.getContext()).load(card.getBgImage().getImageUrl()).into(new CustomTarget<Drawable>() {
                @Override
                public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                    cardView.setBackground(resource);
                }

                @Override
                public void onLoadCleared(@Nullable Drawable placeholder) {

                }
            });
        }
    }

    private void addHiddenIcons(LinearLayout linearLayoutHidden, CardDetails cardDetails,
                                FrameLayout frameLayout, RecyclerView.ViewHolder holder) {

        LinearLayout laterLayout = new LinearLayout(linearLayoutHidden.getContext());
        laterLayout.setOrientation(LinearLayout.VERTICAL);
        laterLayout.setBackground(getDrawableWithRadius());
        laterLayout.setPadding(15, 15, 15, 15);

        ImageView laterIcon = new ImageView(laterLayout.getContext());
        laterIcon.setImageDrawable(ContextCompat.getDrawable(laterLayout.getContext(), R.drawable.later_icon));

        TextView laterText = new TextView(laterLayout.getContext());
        laterText.setText(R.string.remind_later);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(10, 280, 0, 50);

        View.OnClickListener onClickListener = view -> {
            removeCard(frameLayout, holder, cardDetails);
        };

        laterLayout.setOnClickListener(onClickListener);

        laterLayout.setLayoutParams(layoutParams);

        laterLayout.addView(laterIcon);
        laterLayout.addView(laterText);

        LinearLayout dismissLayout = new LinearLayout(linearLayoutHidden.getContext());
        dismissLayout.setOrientation(LinearLayout.VERTICAL);
        dismissLayout.setBackground(getDrawableWithRadius());
        dismissLayout.setPadding(15, 15, 15, 15);

        ImageView dismissIcon = new ImageView(dismissLayout.getContext());
        dismissIcon.setImageDrawable(ContextCompat.getDrawable(dismissLayout.getContext(), R.drawable.dismiss_icon));

        TextView dismissText = new TextView(dismissLayout.getContext());
        dismissText.setText(R.string.dismiss_now);

        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(10, 280, 0, 50);

        dismissLayout.setOnClickListener(onClickListener);

        dismissLayout.setLayoutParams(layoutParams2);

        dismissLayout.addView(dismissIcon);
        dismissLayout.addView(dismissText);

        linearLayoutHidden.addView(laterLayout);
        linearLayoutHidden.addView(dismissLayout);
    }

    private void removeCard(FrameLayout frameLayout, RecyclerView.ViewHolder holder, CardDetails cardDetails) {
        int position = holder.getAdapterPosition();
        dataSet.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, dataSet.size());

        SharedPreferences sharedPreferences = frameLayout.getContext().getSharedPreferences("Pref", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(cardDetails.getId().toString(), true);
        editor.apply();
    }

    private void addIconTitleAndDescription(CardView cardView, Card card, boolean hasArrow) {
        LinearLayout linearLayout = new LinearLayout(cardView.getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setLayoutParams(layoutParams);

        ImageView imageView = new ImageView(linearLayout.getContext());
        LinearLayout.LayoutParams imagelp = new LinearLayout.LayoutParams(150, 150);
        imagelp.setMargins(40, 40, 40, 40);
        imageView.setLayoutParams(imagelp);
        if (card.getIcon() != null) {
            Glide.with(imageView.getContext()).load(card.getIcon().getImageUrl()).into(new CustomTarget<Drawable>() {
                @Override
                public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                    imageView.setImageDrawable(resource);
                }

                @Override
                public void onLoadCleared(@Nullable Drawable placeholder) {

                }
            });
        }
        linearLayout.addView(imageView);

        LinearLayout linearLayoutVertical = new LinearLayout(linearLayout.getContext());
        LinearLayout.LayoutParams llvParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
        llvParams.setMargins(20, 40, 40, 40);
        linearLayoutVertical.setOrientation(LinearLayout.VERTICAL);
        linearLayoutVertical.setLayoutParams(llvParams);

        TextView title = new TextView(linearLayoutVertical.getContext());
        LinearLayout.LayoutParams tvlp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        title.setLayoutParams(tvlp);

        boolean hasTitle = true;

        if (card.getFormattedTitle() == null && card.getTitle() == null) {
            hasTitle = false;
        }

        if (hasTitle) {
            if (card.getFormattedTitle() != null) {
                String text = card.getFormattedTitle().getText();
                int k = 0;
                for (int j = 0; j < text.length(); j++) {
                    if (text.charAt(j) == '{') {
                        Entity entity = card.getFormattedTitle().getEntities().get(k);
                        Spannable spanText = new SpannableString(entity.getText());
                        spanText.setSpan(new ForegroundColorSpan(Color.parseColor(entity.getColor())),
                                0, spanText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        j++;
                        k++;
                        title.append(spanText);
                    } else {
                        title.append(text.charAt(j) + "");
                    }
                }
            } else {
                title.setText(card.getTitle());
            }

            TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(title, 14, 28, 1,
                    TypedValue.COMPLEX_UNIT_DIP);


            title.setGravity(Gravity.CENTER_VERTICAL);

            linearLayoutVertical.addView(title);
        }

        boolean hasDescription = true;

        if (card.getFormattedDescription() == null && card.getDescription() == null) {
            hasDescription = false;
        }

        if (hasDescription) {

            TextView desc = new TextView(linearLayoutVertical.getContext());
            LinearLayout.LayoutParams desclp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            desc.setLayoutParams(desclp);
            if (card.getFormattedDescription() != null) {
                String text = card.getFormattedDescription().getText();
                int k = 0;
                for (int j = 0; j < text.length(); j++) {
                    if (text.charAt(j) == '{') {
                        Entity_ entity = card.getFormattedDescription().getEntities().get(k);
                        Spannable spanText = new SpannableString(entity.getText());
                        spanText.setSpan(new ForegroundColorSpan(Color.parseColor(entity.getColor())),
                                0, spanText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        j++;
                        k++;
                        desc.append(spanText);
                    } else {
                        desc.append(text.charAt(j) + "");
                    }
                }
            } else {
                desc.setText(card.getDescription());
            }

            TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(desc, 12, 25, 1,
                    TypedValue.COMPLEX_UNIT_DIP);

            desc.setGravity(Gravity.CENTER_VERTICAL);
            linearLayoutVertical.addView(desc);
        }

        linearLayoutVertical.setGravity(Gravity.CENTER_VERTICAL);
        linearLayout.addView(linearLayoutVertical);

        if (hasArrow) {
            ImageView arrow = new ImageView(linearLayout.getContext());
            LinearLayout.LayoutParams arrowlp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f);
            arrowlp.setMargins(200, 0, 10, 0);
            arrow.setLayoutParams(arrowlp);
            arrow.setImageDrawable(linearLayout.getContext().getResources().getDrawable(R.drawable.arrow));
            ;
            arrowlp.gravity = Gravity.CENTER_VERTICAL;
            linearLayout.addView(arrow);
        }

        linearLayout.setGravity(Gravity.CENTER_VERTICAL);

        cardView.addView(linearLayout);
    }

    private void addTitle(CardView cardView, Card card, int marginTop, boolean centre) {

        if (card.getFormattedTitle() == null && card.getTitle() == null) return;

        TextView title = new TextView(cardView.getContext());
        if (card.getFormattedTitle() != null) {
            LinearLayout.LayoutParams tvlp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            tvlp.setMargins(40, marginTop, 40, 40);
            title.setLayoutParams(tvlp);

            String text = card.getFormattedTitle().getText();
            int k = 0;
            for (int j = 0; j < text.length(); j++) {
                if (text.charAt(j) == '{') {
                    Entity entity = card.getFormattedTitle().getEntities().get(k);
                    Spannable spanText = new SpannableString(entity.getText());
                    spanText.setSpan(new ForegroundColorSpan(Color.parseColor(entity.getColor())),
                            0, spanText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    j++;
                    k++;
                    title.append(spanText);
                } else {
                    title.append(text.charAt(j) + "");
                }
            }
        } else {
            title.setText(card.getTitle());
        }
        title.setTextSize(25);
        if (centre)
            title.setGravity(Gravity.CENTER_HORIZONTAL);
        cardView.addView(title);
    }

    private void addDesc(CardView cardView, Card card, int marginTop, boolean centre) {

        if (card.getFormattedDescription() == null && card.getDescription() == null) return;

        TextView desc = new TextView(cardView.getContext());
        if (card.getFormattedDescription() != null) {
            LinearLayout.LayoutParams desclp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            desclp.setMargins(40, marginTop, 40, 40);
            desc.setLayoutParams(desclp);
            String text = card.getFormattedDescription().getText();
            int k = 0;
            for (int j = 0; j < text.length(); j++) {
                if (text.charAt(j) == '{') {
                    Entity_ entity = card.getFormattedDescription().getEntities().get(k);
                    Spannable spanText = new SpannableString(entity.getText());
                    spanText.setSpan(new ForegroundColorSpan(Color.parseColor(entity.getColor())),
                            0, spanText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    j++;
                    k++;
                    desc.append(spanText);
                } else {
                    desc.append(text.charAt(j) + "");
                }
            }
        } else {
            desc.setText(card.getDescription());
        }

        desc.setTextSize(20);
        if (centre)
            desc.setGravity(Gravity.CENTER_HORIZONTAL);
        cardView.addView(desc);
    }

    private void addCta(CardView cardView, Card card, int marginTop, boolean centre) {
        if (card.getCta() == null) return;

        LinearLayout linearLayout = new LinearLayout(cardView.getContext());
        LinearLayout.LayoutParams llparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        llparams.setMargins(10, marginTop, 10, 10);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setLayoutParams(llparams);

        List<Ctum> ctaList = card.getCta();

        for (int j = 0; j < ctaList.size(); j++) {
            Button button = new Button(linearLayout.getContext());
            LinearLayout.LayoutParams btnlp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            btnlp.setMargins(40, 40, 40, 40);
            Ctum cta = ctaList.get(j);
            button.setLayoutParams(btnlp);
            button.setText(cta.getText());
            button.setBackgroundColor(Color.parseColor(cta.getBgColor()));
            button.setTextColor(Color.parseColor(cta.getTextColor()));
            button.setOnClickListener(view -> {
                Utils.openLink(cardView.getContext(), cta.getUrl());
            });

            linearLayout.addView(button);
        }

        if (centre)
            linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);

        cardView.addView(linearLayout);
    }

    private void addIcon(CardView cardView, Card card) {
        LinearLayout linearLayout = new LinearLayout(cardView.getContext());
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, 40, 0, 40);
        linearLayout.setLayoutParams(lp);

        ImageView imageView = new ImageView(linearLayout.getContext());
        LinearLayout.LayoutParams imagelp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        imagelp.setMargins(40, 40, 40, 40);
        imageView.setLayoutParams(imagelp);
        if (card.getIcon() != null) {
            Glide.with(imageView.getContext()).load(card.getIcon().getImageUrl()).into(new CustomTarget<Drawable>() {
                @Override
                public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                    imageView.setImageDrawable(resource);
                }

                @Override
                public void onLoadCleared(@Nullable Drawable placeholder) {

                }
            });
        }
        linearLayout.addView(imageView);
        linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        cardView.addView(linearLayout);
    }

    private Drawable getDrawableWithRadius() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(new float[]{20, 20, 20, 20, 20, 20, 20, 20});
        gradientDrawable.setColor(Color.LTGRAY);
        return gradientDrawable;
    }

    public static class HC1TypeViewHolder extends RecyclerView.ViewHolder {

        LinearLayout hc1Layout;

        public HC1TypeViewHolder(View itemView) {
            super(itemView);
            this.hc1Layout = itemView.findViewById(R.id.hc1_layout);
        }
    }

    public static class HC3TypeViewHolder extends RecyclerView.ViewHolder {

        LinearLayout hc3Layout;

        public HC3TypeViewHolder(View itemView) {
            super(itemView);
            this.hc3Layout = itemView.findViewById(R.id.hc3_layout);
        }
    }

    public static class HC4TypeViewHolder extends RecyclerView.ViewHolder {

        LinearLayout hc4Layout;

        public HC4TypeViewHolder(View itemView) {
            super(itemView);
            this.hc4Layout = itemView.findViewById(R.id.hc4_layout);
        }
    }

    public static class HC5TypeViewHolder extends RecyclerView.ViewHolder {

        LinearLayout hc5Layout;

        public HC5TypeViewHolder(View itemView) {
            super(itemView);
            this.hc5Layout = itemView.findViewById(R.id.hc5_layout);
        }
    }

    public static class HC6TypeViewHolder extends RecyclerView.ViewHolder {

        LinearLayout hc6Layout;

        public HC6TypeViewHolder(View itemView) {
            super(itemView);
            this.hc6Layout = itemView.findViewById(R.id.hc6_layout);
        }
    }
}